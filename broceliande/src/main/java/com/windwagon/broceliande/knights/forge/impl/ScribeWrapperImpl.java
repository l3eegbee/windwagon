package com.windwagon.broceliande.knights.forge.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.ScribeData;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.ComponentPatterns;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.ScribeWrapper;
import com.windwagon.broceliande.knights.forge.TaskWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredScribeWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.repositories.ScribeRunRepository;
import com.windwagon.kaamelott.Scribe;

public class ScribeWrapperImpl extends TaskWrapperImpl<Scribe, ArmoredScribeWrapper, ScribeData, ScribeRun>
        implements ScribeWrapper {

    @Autowired
    private ScribeRunRepository scribeRunRepository;

    public ScribeWrapperImpl( Herald herald, ScribeRun runData ) {
        super( herald, runData.getScribe(), runData );
    }

    @Override
    protected void saveRun() {
        scribeRunRepository.save( runData );
    }

    @Override
    public Set<TaskWrapper<?, ?, ?>> getRequiredTasks() throws ForgeException {

        Set<TaskWrapper<?, ?, ?>> tasks = new HashSet<>();

        addRequiredTasksFromConstants( tasks );

        return tasks;

    }

    @Override
    public Set<TaskWrapper<?, ?, ?>> getDependantTasks() {

        Set<TaskWrapper<?, ?, ?>> tasks = new HashSet<>();

        addDependantTasksFromConstants( tasks, ComponentPatterns.getScribeName( this ) );

        return tasks;

    }

    @Override
    public void actorInitialize( ArmoredScribeWrapper armored ) throws ForgeException {

        armored.getActor().initialize();

    }

    @Override
    public void execute( ArmoredScribeWrapper armored ) {

        Scribe scribe = armored.getActor();

        // evaluate
        scribe.evaluate();

        // save the scribe
        runData.setSerialization( base64encode( scribe.marshal() ) );

    }

    @Override
    protected ArmoredScribeWrapper createArmor( Camp camp ) {
        return camp.getScribe( this );
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitScribe( this );
    }

}
