package com.windwagon.broceliande.knights.forge.impl;

import java.util.Set;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.Run;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.entities.Task;
import com.windwagon.broceliande.knights.forge.ComponentPatterns;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.SelectedKnightElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.TrainedKnightElements;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.TaskWrapper;
import com.windwagon.broceliande.knights.forge.constant.ComponentConstantWrapper;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.repositories.BrotherhoodRunRepository;
import com.windwagon.broceliande.knights.repositories.FencingMasterRunRepository;
import com.windwagon.broceliande.knights.repositories.ScribeRunRepository;
import com.windwagon.kaamelott.Actor;
import com.windwagon.kaamelott.Marshallable;

public abstract class TaskWrapperImpl<A extends Actor & Marshallable, D extends Task, R extends Run>
        extends ActorWrapperImpl<A, D> implements TaskWrapper {

    private static final Logger logger = LoggerFactory.getLogger( TaskWrapper.class );

    @Autowired
    protected FencingMasterRunRepository fencingMasterRunRepository;

    @Autowired
    protected BrotherhoodRunRepository brotherhoodRunRepository;

    @Autowired
    protected ScribeRunRepository scribeRunRepository;

    protected R runData;

    protected TaskWrapperImpl( Herald herald, D actorData, R runData ) {
        super( herald, actorData );
        this.runData = runData;
    }

    /*
     * STATUS
     */

    @Override
    public RunStatus getStatus() {
        return runData.getStatus();
    }

    protected abstract void saveRun();

    private void resetStatus( RunStatus runStatus ) {

        runData.setStatus( runStatus );
        runData.setSerialization( null );

        saveRun();

    }

    @Override
    public void todo() {
        resetStatus( RunStatus.TODO );
    }

    @Override
    public void waiting() {
        resetStatus( RunStatus.WAITING );
    }

    @Override
    public void skip() {
        resetStatus( RunStatus.SKIPPED );
    }

    protected RunStatus done() {

        runData.setStatus( RunStatus.DONE );

        saveRun();

        return RunStatus.DONE;

    }

    protected RunStatus fail( Throwable ex ) {

        logger.warn( "Error during executing {}", this, ex );

        runData.setStatus( RunStatus.FAILED );
        runData.setSerialization( ex.toString() );

        saveRun();

        return RunStatus.FAILED;

    }

    /*
     * Marshal
     */

    @Override
    public void marshal() {
        runData.setSerialization( base64encode( actorInstance.marshal() ) );
    }

    @Override
    public void unmarshal() {
        String serialization = runData.getSerialization();
        if( serialization != null )
            actorInstance.unmarshal( base64decode( serialization ) );
    }

    /*
     * DEPENDENCES
     */

    protected void addRequiredTasksFromConstants( Set<TaskWrapper> tasks ) throws ForgeException {

        for( ComponentConstantWrapper constant : componentConstants ) {

            String value = constant.getValue();

            Matcher trainedKnightMatcher = ComponentPatterns.TRAINED_KNIGHT_PATTERN.matcher( value );
            if( trainedKnightMatcher.matches() ) {
                TrainedKnightElements elts = ComponentPatterns.getTrainedKnightElements( trainedKnightMatcher );
                tasks.add(
                        tavern.getFencingMaster(
                                herald,
                                runData.getCycle(),
                                elts.getKnightName(),
                                elts.getFencingMasterName() ) );
            }

            Matcher selectedKnightMatcher = ComponentPatterns.SELECTED_KNIGHT_PATTERN.matcher( value );
            if( selectedKnightMatcher.matches() ) {
                SelectedKnightElements elts = ComponentPatterns.getSelectedKnightElements( selectedKnightMatcher );
                tasks.add( tavern.getBrotherhood( herald, runData.getCycle(), elts.getKnightName() ) );
            }

            Matcher fencingMasterMatcher = ComponentPatterns.FENCING_MASTER_PATTERN.matcher( value );
            if( fencingMasterMatcher.matches() )
                tasks.add( tavern.getFencingMaster( herald, runData.getCycle(), fencingMasterMatcher ) );

            Matcher brotherhoodMatcher = ComponentPatterns.BROTHERHOOD_PATTERN.matcher( value );
            if( brotherhoodMatcher.matches() )
                tasks.add( tavern.getBrotherhood( herald, runData.getCycle(), brotherhoodMatcher ) );

            Matcher scribeMatcher = ComponentPatterns.SCRIBE_PATTERN.matcher( value );
            if( scribeMatcher.matches() )
                tasks.add( tavern.getScribe( herald, runData.getCycle(), scribeMatcher ) );

        }

    }

    protected void addDependantTasksFromConstants( Set<TaskWrapper> tasks, String value ) {

        Set<FencingMasterRun> fencingMasters = fencingMasterRunRepository.findByContainedComponent( value );
        if( fencingMasters != null )
            for( FencingMasterRun fencingMaster : fencingMasters )
                tasks.add( herald.getFencingMaster( fencingMaster ) );

        Set<BrotherhoodRun> brotherhoods = brotherhoodRunRepository.findByContainedComponent( value );
        if( brotherhoods != null )
            for( BrotherhoodRun brotherhood : brotherhoods )
                tasks.add( herald.getBrotherhood( brotherhood ) );

        Set<ScribeRun> scribes = scribeRunRepository.findByContainedComponent( value );
        if( scribes != null )
            for( ScribeRun scribe : scribes )
                tasks.add( herald.getScribe( scribe ) );

    }

    /*
     * OTHERS
     */

    @Override
    public Cycle getCycle() {
        return runData.getCycle();
    }

    @Override
    public R getRunData() {
        return runData;
    }

    @Override
    public String toString() {

        String actorDataName = actorData == null ? null : actorData.getName();
        Cycle runDataCycle = runData == null ? null : runData.getCycle();
        Long runDataCycleId = runDataCycle == null ? null : runDataCycle.getId();

        return new StringBuilder()
                .append( "[" )
                .append( actorDataName )
                .append( ComponentPatterns.CYCLE_SEPARATOR )
                .append( runDataCycleId )
                .append( "]" )
                .toString();

    }

}
