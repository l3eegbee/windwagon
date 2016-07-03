package com.windwagon.broceliande.knights.forge.builder;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.Run;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.logres.builder.Builder;
import com.windwagon.logres.builder.CachedBuilder;

public abstract class RunBuilder<R extends Run, B extends RunBuilder<R, B>> implements Builder<R> {

    @Autowired
    protected KnightBuilderFactory knightBuilderFactory;

    protected R run;

    protected RunBuilder( R run ) {
        this.run = run;
    }

    /*
     * Cycle
     */

    private CachedBuilder<Cycle, CycleBuilder> cycleBuilder =
            new CachedBuilder<>( () -> knightBuilderFactory.getCycleBuilder() );

    @SuppressWarnings( "unchecked" )
    public B cycle( Cycle cycle ) {
        cycleBuilder.set( cycle );
        return (B) this;
    }

    public CycleBuilder cycle() {
        return cycleBuilder.builder();
    }

    /*
     * Status
     */

    @SuppressWarnings( "unchecked" )
    public B status( RunStatus status ) {
        run.setStatus( status );
        return (B) this;
    }

    /*
     * Exec duration
     */

    @SuppressWarnings( "unchecked" )
    public B executionDuration( Long executionDuration ) {
        run.setExecutionDuration( executionDuration );
        return (B) this;
    }

    /*
     * Serialization
     */

    @SuppressWarnings( "unchecked" )
    public B serialization( String serialization ) {
        run.setSerialization( serialization );
        return (B) this;
    }

    /*
     * Build
     */

    @Override
    public R build() {

        run.setCycle( cycleBuilder.build() );

        return run;

    }

}
