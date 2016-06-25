package com.windwagon.logres.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mail.default")
public class DefaultConfig {

    private boolean enabled;

    private String from;

    private String to;

    private String subject;

    private String charset;

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom( String from ) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo( String to ) {
        this.to = to;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject( String subject ) {
        this.subject = subject;
    }

    public String getCharset() {
        return this.charset;
    }

    public void setCharset( String charset ) {
        this.charset = charset;
    }

}
