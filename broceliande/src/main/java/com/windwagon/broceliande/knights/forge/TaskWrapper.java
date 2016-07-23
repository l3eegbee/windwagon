package com.windwagon.broceliande.knights.forge;

import java.util.Set;

import com.windwagon.broceliande.knights.entities.Run;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.entities.Task;
import com.windwagon.broceliande.knights.forge.armored.ArmoredTaskWrapper;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public interface TaskWrapper<Armored extends ArmoredTaskWrapper<?, R>, T extends Task, R extends Run>
        extends ActorWrapper<Armored, T> {

    /*
     * EXECUTION
     */

    public RunStatus run();

    public void todo();

    public void waiting();

    public void skip();

    /*
     * DEPENDENCES
     */

    public Set<? extends TaskWrapper<?, ?, ?>> getRequiredTasks() throws ForgeException;

    public Set<? extends TaskWrapper<?, ?, ?>> getDependantTasks() throws ForgeException;

    /*
     * OTHERS
     */

    public R getRunData();

}
