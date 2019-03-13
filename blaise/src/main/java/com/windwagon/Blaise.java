package com.windwagon;

import com.windwagon.broceliande.*;

import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.concurrent.*;

@SpringBootApplication
@Import(Broceliande.class)
public class Blaise {

	@Bean
	public ThreadPoolTaskScheduler getScheduler() {
		return new ThreadPoolTaskScheduler();
	}

	public static void main(String... args) {
		new SpringApplicationBuilder(Blaise.class).properties("maestro.start=true").run(args);
	}

}
