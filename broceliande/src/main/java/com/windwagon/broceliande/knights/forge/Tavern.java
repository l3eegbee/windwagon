package com.windwagon.broceliande.knights.forge;

import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.entities.SquireData;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.BrotherhoodElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.ComponentElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.FencingMasterElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.OfficialComponentElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.OfficialKnightElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.SquireElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.ScribeElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.SelectedKnightElements;
import com.windwagon.broceliande.knights.forge.ComponentPatterns.TrainedKnightElements;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.repositories.BrotherhoodRunRepository;
import com.windwagon.broceliande.knights.repositories.ComponentClassRepository;
import com.windwagon.broceliande.knights.repositories.FencingMasterRunRepository;
import com.windwagon.broceliande.knights.repositories.OfficialKnightDataRepository;
import com.windwagon.broceliande.knights.repositories.SquireDataRepository;
import com.windwagon.broceliande.knights.repositories.ScribeRunRepository;

@Component
public class Tavern {

    @Autowired
    private OfficialKnightDataRepository officialKnightDataRepository;

    @Autowired
    private FencingMasterRunRepository fencingMasterRunRepository;

    @Autowired
    private BrotherhoodRunRepository brotherhoodRunRepository;

    @Autowired
    private ScribeRunRepository scribeRunRepository;

    @Autowired
    private SquireDataRepository squireDataRepository;

    @Autowired
    private ComponentClassRepository componentClassRepository;

    public ComponentWrapper findComponent( Herald herald, Cycle cycle, String completeName ) throws ForgeException {

        try {

            if( completeName == null || completeName.isEmpty() )
                return getNullComponent( herald );

            Matcher officialKnightMatcher = ComponentPatterns.OFFICIAL_KNIGHT_PATTERN.matcher( completeName );
            if( officialKnightMatcher.matches() )
                return getOfficialKnight( herald, officialKnightMatcher );

            Matcher trainedKnightMatcher = ComponentPatterns.TRAINED_KNIGHT_PATTERN.matcher( completeName );
            if( trainedKnightMatcher.matches() )
                return getTrainedKnight( herald, cycle, trainedKnightMatcher );

            Matcher selectedKnightMatcher = ComponentPatterns.SELECTED_KNIGHT_PATTERN.matcher( completeName );
            if( selectedKnightMatcher.matches() )
                return getSelectedKnight( herald, cycle, selectedKnightMatcher );

            Matcher fencingMasterMatcher = ComponentPatterns.FENCING_MASTER_PATTERN.matcher( completeName );
            if( fencingMasterMatcher.matches() )
                return getFencingMaster( herald, cycle, fencingMasterMatcher );

            Matcher brotherhoodMatcher = ComponentPatterns.BROTHERHOOD_PATTERN.matcher( completeName );
            if( brotherhoodMatcher.matches() )
                return getBrotherhood( herald, cycle, brotherhoodMatcher );

            Matcher scribeMatcher = ComponentPatterns.SCRIBE_PATTERN.matcher( completeName );
            if( scribeMatcher.matches() )
                return getScribe( herald, cycle, scribeMatcher );

            Matcher squireMatcher = ComponentPatterns.SQUIRE_PATTERN.matcher( completeName );
            if( squireMatcher.matches() )
                return getSquire( herald, cycle, squireMatcher );

            Matcher officialComponentMatcher = ComponentPatterns.OFFICIAL_COMPONENT_PATTERN.matcher( completeName );
            if( officialComponentMatcher.matches() )
                return getOfficialComponent( herald, officialComponentMatcher );

            Matcher componentMatcher = ComponentPatterns.COMPONENT_PATTERN.matcher( completeName );
            if( componentMatcher.matches() )
                return getComponent( herald, componentMatcher );

        } catch( ForgeException ex ) {
            throw new ForgeException(
                    "Exception during getting component [" + completeName + "]: " + ex.getMessage(),
                    ex );
        }

        throw new ForgeException( "No component match syntax [" + completeName + "]" );

    }

    public OfficialKnightWrapper getOfficialKnight( Herald herald, Matcher matcher ) throws ForgeException {
        OfficialKnightElements elts = ComponentPatterns.getOfficialKnightElements( matcher );
        return getOfficialKnight( herald, elts.getKnightName(), elts.getOfficialId() );
    }

    public OfficialKnightWrapper getOfficialKnight( Herald herald, String kname, String offid ) throws ForgeException {

        OfficialKnightData knightData =
                officialKnightDataRepository.findByNameAndComponentComponentClassOfficialId( kname, offid );

        if( knightData == null )
            throw new ForgeException( "Official knight [" + kname + "][" + offid + "] not found." );

        return herald.getOfficialKnight( knightData );

    }

    public KnightWrapper getTrainedKnight( Herald herald, Cycle cycle, Matcher matcher ) throws ForgeException {
        TrainedKnightElements elts = ComponentPatterns.getTrainedKnightElements( matcher );
        return getTrainedKnight( herald, cycle, elts.getKnightName(), elts.getFencingMasterName() );
    }

    public KnightWrapper getTrainedKnight( Herald herald, Cycle cycle, String kname, String fmname )
            throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        FencingMasterRun fencingMasterRun =
                fencingMasterRunRepository
                        .findByCycleAndFencingMasterBrotherhoodNameAndFencingMasterName( cycle, kname, fmname );

        if( fencingMasterRun == null )
            throw new ForgeException( "Trained knight [" + kname + "][" + fmname + "] not found." );

        return herald.getKnight( fencingMasterRun );

    }

    public KnightWrapper getSelectedKnight( Herald herald, Cycle cycle, Matcher matcher ) throws ForgeException {
        SelectedKnightElements elts = ComponentPatterns.getSelectedKnightElements( matcher );
        return getSelectedKnight( herald, cycle, elts.getKnightName() );
    }

    public KnightWrapper getSelectedKnight( Herald herald, Cycle cycle, String kname ) throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        BrotherhoodRun brotherhoodRun = brotherhoodRunRepository.findByCycleAndBrotherhoodName( cycle, kname );

        if( brotherhoodRun == null )
            throw new ForgeException( "Selected knight [" + kname + "] not found." );
        if( brotherhoodRun.getSelected() == null )
            throw new ForgeException( "Knight [" + kname + "] not selected yet." );

        return herald.getKnight( brotherhoodRun.getSelected() );

    }

    public FencingMasterWrapper getFencingMaster( Herald herald, Cycle cycle, Matcher matcher ) throws ForgeException {
        FencingMasterElements elts = ComponentPatterns.getFencingMasterElements( matcher );
        return getFencingMaster( herald, cycle, elts.getKnightName(), elts.getFencingMasterName() );
    }

    public FencingMasterWrapper getFencingMaster( Herald herald, Cycle cycle, String kname, String fmname )
            throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        FencingMasterRun fencingMasterRun =
                fencingMasterRunRepository
                        .findByCycleAndFencingMasterBrotherhoodNameAndFencingMasterName( cycle, kname, fmname );

        if( fencingMasterRun == null )
            throw new ForgeException( "Fencing master [" + kname + "][" + fmname + "] not found." );

        return herald.getFencingMaster( fencingMasterRun );

    }

    public BrotherhoodWrapper getBrotherhood( Herald herald, Cycle cycle, Matcher matcher ) throws ForgeException {
        BrotherhoodElements elts = ComponentPatterns.getBrotherhoodElements( matcher );
        return getBrotherhood( herald, cycle, elts.getName() );
    }

    public BrotherhoodWrapper getBrotherhood( Herald herald, Cycle cycle, String kname ) throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        BrotherhoodRun brotherhoodRun = brotherhoodRunRepository.findByCycleAndBrotherhoodName( cycle, kname );

        if( brotherhoodRun == null )
            throw new ForgeException( "Brotherhood [" + kname + "] not found." );

        return herald.getBrotherhood( brotherhoodRun );

    }

    public ScribeWrapper getScribe( Herald herald, Cycle cycle, Matcher matcher ) throws ForgeException {
        ScribeElements elts = ComponentPatterns.getScribeElements( matcher );
        return getScribe( herald, cycle, elts.getName() );
    }

    public ScribeWrapper getScribe( Herald herald, Cycle cycle, String sname ) throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        ScribeRun scribeRun = scribeRunRepository.findByCycleAndScribeName( cycle, sname );

        if( scribeRun == null )
            throw new ForgeException( "Scribe [" + sname + "] not found." );

        return herald.getScribe( scribeRun );

    }

    public SquireWrapper getSquire( Herald herald, Cycle cycle, Matcher matcher ) throws ForgeException {
        SquireElements elts = ComponentPatterns.getSquireElements( matcher );
        return getSquire( herald, cycle, elts.getName() );
    }

    public SquireWrapper getSquire( Herald herald, Cycle cycle, String pname ) throws ForgeException {

        if( cycle == null )
            throw new ForgeException( "Cycle must be defined." );

        SquireData squireData = squireDataRepository.findByName( pname );

        if( squireData == null )
            throw new ForgeException( "Squire [" + pname + "] not found." );

        return herald.getSquire( cycle, squireData );

    }

    public ComponentWrapper getOfficialComponent( Herald herald, Matcher matcher ) throws ForgeException {
        OfficialComponentElements elts = ComponentPatterns.getOfficialComponentElements( matcher );
        return getOfficialComponent( herald, elts.getMainName(), elts.getOfficialId() );
    }

    public ComponentWrapper getOfficialComponent( Herald herald, String mainName, String offid ) throws ForgeException {

        ComponentClass componentClass = componentClassRepository.findByMainClassAndOfficialId( mainName, offid );

        if( componentClass == null )
            throw new ForgeException( "Official component class [" + mainName + "][" + offid + "] not found." );

        return herald.getComponent( componentClass );

    }

    public ComponentWrapper getComponent( Herald herald, Matcher matcher ) throws ForgeException {
        ComponentElements elts = ComponentPatterns.getComponentElements( matcher );
        return getComponent( herald, elts.getMainName() );
    }

    public ComponentWrapper getComponent( Herald herald, String mainName ) throws ForgeException {

        ComponentClass componentClass = componentClassRepository.findByMainClassAndOfficialId( mainName, null );

        if( componentClass == null )
            throw new ForgeException( "Component class [" + mainName + "] not found." );

        return herald.getComponent( componentClass );

    }

    public NullComponentWrapper getNullComponent( Herald herald ) throws ForgeException {
        return herald.getNull();
    }

}
