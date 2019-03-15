package com.windwagon.viviane;

import com.windwagon.*;

import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.shell.*;
import org.springframework.shell.core.*;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.windwagon.viviane", "org.springframework.shell.commands", "org.springframework.shell.plugin.support"})
@Import(Blaise.class)

public class Viviane {

	public static void main(String... args) {

		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Viviane.class).run(args);

		JLineShellComponent shell = ctx.getBean(JLineShellComponent.class);
		shell.setPrintBanner(false);
		shell.start();
		shell.promptLoop();
		shell.waitForComplete();

		ctx.close();

	}

	// is necessary, autowired in:
	// org.springframework.shell.converters.AvailableCommandsConverter
	@Bean(name = "shell")
	public JLineShellComponent jLineShellComponent() {
		return new JLineShellComponent();
	}

	// is necessary, autowired in:
	// org.springframework.shell.core.JLineShellComponent
	@Bean
	public CommandLine commandLine() {
		return new CommandLine(null, 3000, null);
	}

}
