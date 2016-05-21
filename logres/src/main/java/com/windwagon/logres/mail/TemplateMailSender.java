package com.windwagon.logres.mail;

import java.util.HashMap;
import java.util.Map;

public interface TemplateMailSender {

    public void send( Map<String, Object> context );

    default public void send() {
        send( new HashMap<>() );
    }

}
