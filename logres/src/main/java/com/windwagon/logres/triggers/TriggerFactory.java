package com.windwagon.logres.triggers;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TriggerFactory {

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public MonthlyTrigger getMonthlyTrigger( int day, LocalTime hour ) {
        return new MonthlyTrigger( day, hour );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public WeeklyTrigger getWeeklyTrigger( DayOfWeek day, LocalTime hour ) {
        return new WeeklyTrigger( day, hour );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public DailyTrigger getDailyTrigger( LocalTime hour ) {
        return new DailyTrigger( hour );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public OffsetTrigger getOffsetTrigger() {
        return new OffsetTrigger();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public Offset getOffset( Duration duration, boolean repeatly ) {
        return new Offset( duration, repeatly );
    }

}
