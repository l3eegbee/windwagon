package com.windwagon.kaamelott;

public class LoadKnightException extends Exception {

    private static final long serialVersionUID = 1L;

    public LoadKnightException() {
        super();
    }

    public LoadKnightException( String message ) {
        super( message );
    }

    public LoadKnightException( String message, Throwable cause ) {
        super( message, cause );
    }

    public LoadKnightException( Throwable cause ) {
        super( cause );
    }

}
