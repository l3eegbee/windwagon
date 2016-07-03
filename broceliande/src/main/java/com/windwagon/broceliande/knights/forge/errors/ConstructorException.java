package com.windwagon.broceliande.knights.forge.errors;

public class ConstructorException extends ForgeException {

    private static final long serialVersionUID = 1L;

    public ConstructorException() {
        super();
    }

    public ConstructorException( String message ) {
        super( message );
    }

    public ConstructorException( String message, Throwable cause ) {
        super( message, cause );
    }

    public ConstructorException( Throwable cause ) {
        super( cause );
    }

}
