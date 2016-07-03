package com.windwagon.broceliande.knights.forge.builder;

import com.windwagon.broceliande.knights.entities.Task;

public abstract class TaskBuilder<T extends Task, B extends TaskBuilder<T, B>>
        extends ActorDataBuilder<T, B> {

    protected TaskBuilder( T actorData ) {
        super( actorData );
    }

}
