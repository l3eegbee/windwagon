package com.windwagon.broceliande.knights.forge.errors;

public class ForgeException extends Exception {

    private static final long serialVersionUID = 1L;

    public ForgeException() {
        super();
    }

    public ForgeException( String message ) {
        super( message );
    }

    public ForgeException( String message, Throwable cause ) {
        super( message, cause );
    }

    public ForgeException( Throwable cause ) {
        super( cause );
    }

}
