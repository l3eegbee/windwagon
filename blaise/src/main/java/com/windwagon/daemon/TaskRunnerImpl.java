package com.windwagon.daemon;

import com.windwagon.logres.mail.*;

import org.apache.commons.lang.exception.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

import javax.annotation.*;

public class TaskRunnerImpl implements TaskRunner {

    private final static Logger logger = LoggerFactory.getLogger( RaceTaskRunnerImpl.class );

    @Autowired
    private TemplateMailSenderFactory templateMailSenderFactory;

    private Task task;

    private TemplateMailSender successMailSender;

    private TemplateMailSender errorMailSender;

    public TaskRunnerImpl( Task task ) {
        this.task = task;
    }

    @PostConstruct
    public void init() {

        successMailSender = templateMailSenderFactory
                .getTemplateMailSender( task.getEnvKey() + Maestro.ENV_MAIL_SUCCESS_SUFFIX );
        errorMailSender = templateMailSenderFactory
                .getTemplateMailSender( task.getEnvKey() + Maestro.ENV_MAIL_ERROR_SUFFIX );

    }

    @Override
    @Transactional
    public void run() {

        Map<String, Object> context = new HashMap<>();

        try {

            task.run( context );

            successMailSender.send( context );

        } catch( Throwable ex ) {

            logger.error( "Error during executing task {}", task.getName(), ex );

            context.put( Maestro.CXT_STACKTRACE, ExceptionUtils.getStackTrace( ex ) );
            errorMailSender.send( context );

        }

    }

}
