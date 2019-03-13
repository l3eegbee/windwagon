package com.windwagon.logres.triggers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.TaskScheduler;

import com.windwagon.logres.Logres;
import com.windwagon.logres.test.AdjustableClock;

@SpringBootApplication
@Import(Logres.class)
public class TriggerTestsConfig {

	@Bean
	public AdjustableClock getClock() {
		return new AdjustableClock();
	}

	@Bean
	public TaskScheduler getScheduler() {
		return new FakeScheduler();
	}

}
