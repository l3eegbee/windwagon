package com.windwagon.pmuportal.exceptions;

import java.net.URL;

public class PMUNoContent extends PMUNavigatorError {

    private static final long serialVersionUID = 1L;

    public PMUNoContent( URL url ) {
        this( url.toString() );
    }

    public PMUNoContent( String url ) {
        super( "Can't access " + url + ": no content returned" );
    }

}
