package com.windwagon.broceliande.knights.forge;

import java.util.Set;

import com.windwagon.broceliande.knights.entities.Run;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public interface TaskWrapper extends ActorWrapper {

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

    public Set<? extends TaskWrapper> getRequiredTasks() throws ForgeException;

    public Set<? extends TaskWrapper> getDependantTasks() throws ForgeException;

    /*
     * OTHERS
     */

    public Run getRunData();

}
