package com.windwagon.broceliande.knights.forge.errors;

public class ActorExecutionException extends ForgeException {

    private static final long serialVersionUID = 1L;

    public ActorExecutionException() {
        super();
    }

    public ActorExecutionException( String message ) {
        super( message );
    }

    public ActorExecutionException( String message, Throwable cause ) {
        super( message, cause );
    }

    public ActorExecutionException( Throwable cause ) {
        super( cause );
    }

}
