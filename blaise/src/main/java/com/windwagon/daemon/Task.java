package com.windwagon.daemon;

import java.util.Map;

public interface Task {

    String getName();

    default String getEnvKey() {
        return Maestro.ENV_TASKS_PREFIX + getName();
    }

    void run(Map<String, Object> reportContext) throws Exception;

}
