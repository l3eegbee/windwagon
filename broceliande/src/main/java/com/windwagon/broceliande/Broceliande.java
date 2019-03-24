package com.windwagon.broceliande;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import java.time.*;
import java.util.*;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@PropertySource("broceliande.properties")
public class Broceliande {

	@Bean
	public Clock getClock(@Value("${timezone}") String timezone) {

		TimeZone.setDefault(TimeZone.getTimeZone(timezone));

		return Clock.systemDefaultZone();

	}

}
