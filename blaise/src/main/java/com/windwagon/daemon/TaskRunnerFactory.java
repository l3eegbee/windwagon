package com.windwagon.daemon;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.windwagon.logres.triggers.OffsetTrigger;

@Configuration
public class TaskRunnerFactory {

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public TaskRunner getTaskRunner( Task task ) {
        return new TaskRunnerImpl( task );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public RaceTaskRunner getRaceTaskRunner(
            Long raceId,
            RaceTask raceTask,
            OffsetTrigger offsetTriger ) {
        return new RaceTaskRunnerImpl( raceId, raceTask, offsetTriger );
    }

}
