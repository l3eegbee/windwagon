package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "ww_squire" )
public class SquireData extends ActorData implements Comparable<SquireData> {

    public static final Comparator<SquireData> COMPARATOR =
            Comparator.comparing( SquireData::getName, Comparator.nullsFirst( String::compareTo ) );

    @Override
    public int compareTo( SquireData squireData ) {
        return COMPARATOR.compare( this, squireData );
    }

}
