package com.windwagon.broceliande.knights.forge.errors;

public class ForgeError extends Error {

    private static final long serialVersionUID = 1L;

    private ForgeException cause;

    public ForgeError( ForgeException cause ) {
        super( cause );
    }

    @Override
    public ForgeException getCause() {
        return cause;
    }

}
