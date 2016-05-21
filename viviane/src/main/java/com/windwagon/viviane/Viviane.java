package com.windwagon.viviane;

import jline.console.ConsoleReader;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.shell.CommandLine;
import org.springframework.shell.core.JLineShellComponent;

import com.windwagon.Blaise;

@Configuration
@EnableAutoConfiguration
@ComponentScan( {
        "com.windwagon.viviane",
        "org.springframework.shell.commands",
        "org.springframework.shell.plugin.support" } )
@Import( Blaise.class )
public class Viviane {

    public static void main( String ... args ) {

        ConfigurableApplicationContext ctx =
                new SpringApplicationBuilder( Viviane.class ).run( args );

        JLineShellComponent shell = ctx.getBean( JLineShellComponent.class );
        shell.setPrintBanner( false );
        shell.start();
        shell.promptLoop();
        shell.waitForComplete();

        ctx.close();

    }

    public static class ConsoleReaderAccessibleJLineShellComponent extends JLineShellComponent {

        public ConsoleReader getConsoleReader() {
            return this.reader;
        }

    }

    // is necessary, autowired in:
    // org.springframework.shell.converters.AvailableCommandsConverter
    @Bean( name = "shell" )
    public ConsoleReaderAccessibleJLineShellComponent jLineShellComponent() {
        return new ConsoleReaderAccessibleJLineShellComponent();
    }

    // is necessary, autowired in:
    // org.springframework.shell.core.JLineShellComponent
    @Bean
    public CommandLine commandLine() {
        return new CommandLine( null, 3000, null );
    }

}
