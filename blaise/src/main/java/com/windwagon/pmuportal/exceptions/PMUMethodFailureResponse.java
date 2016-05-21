package com.windwagon.pmuportal.exceptions;

import java.net.URL;

public class PMUMethodFailureResponse extends PMUNavigatorError {

    private static final long serialVersionUID = 1L;

    public static final int HTTP_RESPONSE_CODE = 420;

    public PMUMethodFailureResponse( URL url ) {
        this( url.toString() );
    }

    public PMUMethodFailureResponse( String url ) {
        super( "Can't access " + url + ": HTTP response code " + HTTP_RESPONSE_CODE );
    }

}
