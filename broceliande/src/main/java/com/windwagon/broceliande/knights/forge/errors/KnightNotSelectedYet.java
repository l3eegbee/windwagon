package com.windwagon.broceliande.knights.forge.errors;

import com.windwagon.kaamelott.LoadKnightException;

public class KnightNotSelectedYet extends LoadKnightException {
    
    private static final long serialVersionUID = 1L;

    public KnightNotSelectedYet() {
        super();
    }

    public KnightNotSelectedYet( String message ) {
        super( message );
    }

    public KnightNotSelectedYet( String message, Throwable cause ) {
        super( message, cause );
    }

    public KnightNotSelectedYet( Throwable cause ) {
        super( cause );
    }
    

}
