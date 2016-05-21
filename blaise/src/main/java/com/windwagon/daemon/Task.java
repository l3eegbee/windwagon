package com.windwagon.daemon;

import java.util.Map;

public interface Task {

    public String getName();

    default public String getEnvKey() {
        return Maestro.ENV_TASKS_PREFIX + getName();
    }

    public void run( Map<String, Object> reportContext ) throws Exception;

}
