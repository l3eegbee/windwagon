package com.windwagon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

@SpringBootApplication
@Import( Blaise.class )
@TestPropertySource( "classpath:/blaise.test.properties" )
public class BlaiseTest {}
