package com.windwagon.broceliande.knights.forge.errors;

public class LoadJARException extends ForgeException {

    private static final long serialVersionUID = 1L;

    public LoadJARException() {
        super();
    }

    public LoadJARException( String message ) {
        super( message );
    }

    public LoadJARException( String message, Throwable cause ) {
        super( message, cause );
    }

    public LoadJARException( Throwable cause ) {
        super( cause );
    }

}
