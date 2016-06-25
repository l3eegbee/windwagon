package com.windwagon.logres.mail;

import java.io.IOException;
import java.io.StringReader;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.node.SimpleNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class MailConfigImpl implements MailConfig {

    private static String MAIL_ENABLED = "enabled";

    private static String MAIL_TO = "to";

    private static String MAIL_FROM = "from";

    private static String MAIL_SUBJECT = "subject";

    private static String MAIL_CONTENT = "content";

    private static String MAIL_CHARSET = "charset";

    private static String TEMPLATE_NAME_FROM = "mailFrom";

    private static String TEMPLATE_NAME_TO = "mailTo";

    private static String TEMPLATE_NAME_SUBJECT = "mailSubject";

    private static String TEMPLATE_NAME_CONTENT = "mailContent";

    @Autowired
    private DefaultConfig defaultConfig;

    @Autowired
    private PropertyResolver propertyResolver;

    @Autowired
    private ResourceLoader resourceLoader;

    private String confId;

    private boolean enabled = true;

    private Template mailFrom;

    private Template mailTo;

    private Template mailSubject;

    private Template mailContent;

    public MailConfigImpl( String confId ) {
        this.confId = confId;
    }

    private String prop( String val, String def ) {
        return propertyResolver.getProperty( confId + "." + val, def );
    }

    private String prop( String val ) {
        return prop( val, null );
    }

    private Template templatize( String name, String string ) {

        try {

            RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();

            StringReader reader = new StringReader( string );
            SimpleNode node = runtimeServices.parse( reader, name );

            Template template = new Template();
            template.setRuntimeServices( runtimeServices );
            template.setData( node );
            template.initDocument();

            return template;

        } catch( Exception ex ) {
            throw new RuntimeException( "Can't templatize [" + string + "] (" + name + ")", ex );
        }

    }

    @PostConstruct
    public void init() {

        enabled = propertyResolver
                .getProperty( MAIL_ENABLED, Boolean.class, defaultConfig.getEnabled() );
        if( !enabled )
            return;

        String content = prop( MAIL_CONTENT );
        if( content != null ) {

            String charset = prop( MAIL_CHARSET, defaultConfig.getCharset() );

            Resource resource = resourceLoader.getResource( content );

            String contentSource = "";
            if( !resource.exists() )
                contentSource = content;
            else {
                try {
                    contentSource = IOUtils.toString( resource.getInputStream(), charset );
                } catch( IOException ex ) {
                    throw new RuntimeException( "Can't read [" + content + "].", ex );
                }

            }

            mailContent = templatize( TEMPLATE_NAME_CONTENT, contentSource );

        } else {
            enabled = false;
            return;
        }

        mailFrom = templatize( TEMPLATE_NAME_FROM, prop( MAIL_FROM, defaultConfig.getFrom() ) );
        mailTo = templatize( TEMPLATE_NAME_TO, prop( MAIL_TO, defaultConfig.getTo() ) );
        mailSubject =
                templatize( TEMPLATE_NAME_SUBJECT, prop( MAIL_SUBJECT, defaultConfig.getSubject() ) );

    }

    @Override
    public boolean enabled() {
        return enabled;
    }

    @Override
    public Template from() {
        return mailFrom;
    }

    @Override
    public Template to() {
        return mailTo;
    }

    @Override
    public Template subject() {
        return mailSubject;
    }

    @Override
    public Template content() {
        return mailContent;
    }

}
