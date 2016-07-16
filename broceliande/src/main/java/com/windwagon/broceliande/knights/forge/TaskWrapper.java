package com.windwagon.broceliande.knights.forge;

import java.util.Set;

import com.windwagon.broceliande.knights.entities.Run;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.entities.Task;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.Actor;

public interface TaskWrapper<A extends Actor, T extends Task, R extends Run> extends ActorWrapper<A, T> {

    /*
     * EXECUTION
     */

    public RunStatus run();

    /*
     * STATUS
     */

    public RunStatus getStatus();

    public void todo();

    public void waiting();

    public void skip();

    /*
     * Marshal
     */

    public void marshal();

    public void unmarshal();

    /*
     * DEPENDENCES
     */

    public Set<? extends TaskWrapper<?,?,?>> getRequiredTasks() throws ForgeException;

    public Set<? extends TaskWrapper<?,?,?>> getDependantTasks() throws ForgeException;

    /*
     * OTHERS
     */

    public R getRunData();

}
