package com.windwagon.broceliande.knights.forge.errors;

public class LoadClassException extends ForgeException {

    private static final long serialVersionUID = 1L;

    public LoadClassException() {
        super();
    }

    public LoadClassException( String message ) {
        super( message );
    }

    public LoadClassException( String message, Throwable cause ) {
        super( message, cause );
    }

    public LoadClassException( Throwable cause ) {
        super( cause );
    }

}
