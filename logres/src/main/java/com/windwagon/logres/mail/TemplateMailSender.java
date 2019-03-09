package com.windwagon.logres.mail;

import java.util.HashMap;
import java.util.Map;

public interface TemplateMailSender {

    void send(Map<String, Object> context);

    default void send() {
        send( new HashMap<>() );
    }

}
