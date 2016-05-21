package com.windwagon.logres.triggers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

public class OffsetTrigger {

    @Autowired
    private TriggerFactory triggerFactory;

    private List<Offset> offsets;

    public void setOffsets( Collection<Offset> offsets ) {
        this.offsets = new Vector<Offset>( offsets );
        Collections.sort( this.offsets );
    }

    public void setOffsets( Offset ... offsets ) {
        setOffsets( Arrays.asList( offsets ) );
    }

    public void setOffsets( String offsets ) {
        setOffsets( TriggersParser.getParser( offsets, triggerFactory ).offsets().offs );
    }

    public List<Offset> getOffsets() {
        return offsets;
    }

    public Date nextExecutionTime( Date ref ) {

        for( Offset offset : offsets ) {
            Date next = offset.nextDate( ref );
            if( next != null )
                return next;
        }

        return null;

    }

    @Override
    public boolean equals( Object obj ) {

        if( this == obj )
            return true;
        if( obj == null || getClass() != obj.getClass() )
            return false;

        OffsetTrigger other = (OffsetTrigger) obj;

        if( !Objects.equals( offsets, other.offsets ) )
            return false;

        return true;

    }

    @Override
    public String toString() {
        return "offsets:"
                + offsets.stream().map( Object::toString ).collect( Collectors.joining( "," ) );
    }

}
