package com.windwagon.broceliande.knights.forge.errors;

public class ConstraintsFormatException extends ForgeException {
    
    private static final long serialVersionUID = 1L;

    public ConstraintsFormatException() {
        super();
    }

    public ConstraintsFormatException( String message ) {
        super( message );
    }

    public ConstraintsFormatException( String message, Throwable cause ) {
        super( message, cause );
    }

    public ConstraintsFormatException( Throwable cause ) {
        super( cause );
    }


}
