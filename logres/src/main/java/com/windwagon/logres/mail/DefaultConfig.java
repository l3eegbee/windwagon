package com.windwagon.logres.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DefaultConfig {

    @Value( "${mail.default.enabled}" )
    private boolean enabled;

    @Value( "${mail.default.from}" )
    private String from;

    @Value( "${mail.default.to}" )
    private String to;

    @Value( "${mail.default.subject}" )
    private String subject;

    @Value( "${mail.default.charset}" )
    private String charset;

    public boolean enabled() {
        return this.enabled;
    }

    public String from() {
        return this.from;
    }

    public String to() {
        return this.to;
    }

    public String subject() {
        return this.subject;
    }

    public String charset() {
        return this.charset;
    }

}
