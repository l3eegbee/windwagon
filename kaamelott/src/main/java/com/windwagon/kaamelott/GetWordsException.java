package com.windwagon.kaamelott;

public class GetWordsException extends Exception {

    private static final long serialVersionUID = 1L;

    public GetWordsException() {
        super();
    }

    public GetWordsException( String message ) {
        super( message );
    }

    public GetWordsException( String message, Throwable cause ) {
        super( message, cause );
    }

    public GetWordsException( Throwable cause ) {
        super( cause );
    }

}
