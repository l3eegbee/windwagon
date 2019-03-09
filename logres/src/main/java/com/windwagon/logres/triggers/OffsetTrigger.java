package com.windwagon.logres.triggers;

import android.annotation.*;

import org.springframework.beans.factory.annotation.*;

import java.util.*;
import java.util.stream.*;

@SuppressLint("NewApi")
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

        return Objects.equals(offsets, other.offsets);

    }

    @Override
    public String toString() {
        return "offsets:"
                + offsets.stream().map( Object::toString ).collect( Collectors.joining( "," ) );
    }

}
