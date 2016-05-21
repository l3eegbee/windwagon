package com.windwagon.kaamelott;

public class TaskInterruptedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TaskInterruptedException() {
        super();
    }

    public TaskInterruptedException( String message ) {
        super( message );
    }

    public TaskInterruptedException( String message, Throwable cause ) {
        super( message, cause );
    }

    public TaskInterruptedException( Throwable cause ) {
        super( cause );
    }

}
