package com.windwagon.broceliande.knights.forge.errors;

public class ConstantException extends ForgeException {

    private static final long serialVersionUID = 1L;

    public ConstantException() {
        super();
    }

    public ConstantException( String message ) {
        super( message );
    }

    public ConstantException( String message, Throwable cause ) {
        super( message, cause );
    }

    public ConstantException( Throwable cause ) {
        super( cause );
    }

}
