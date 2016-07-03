package com.windwagon.broceliande.knights.forge.errors;

public class LoadActorDataException extends ForgeException {

    private static final long serialVersionUID = 1L;

    public LoadActorDataException() {
        super();
    }

    public LoadActorDataException( String message ) {
        super( message );
    }

    public LoadActorDataException( String message, Throwable cause ) {
        super( message, cause );
    }

    public LoadActorDataException( Throwable cause ) {
        super( cause );
    }

}
