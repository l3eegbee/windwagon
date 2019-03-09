package com.windwagon.logres.mail;

import org.apache.velocity.Template;

public interface MailConfig {

    boolean enabled();

    Template from();

    Template to();

    Template subject();

    Template content();

}
