package com.windwagon.logres.mail;

import org.apache.velocity.Template;

public interface MailConfig {
    
    public boolean enabled();

    public Template from();

    public Template to();

    public Template subject();

    public Template content();

}
