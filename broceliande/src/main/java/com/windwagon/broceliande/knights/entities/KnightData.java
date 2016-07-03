package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "ww_knight" )
public class KnightData extends ActorData implements Comparable<KnightData> {

    public static final Comparator<KnightData> COMPARATOR =
            Comparator.comparing( KnightData::getName, Comparator.nullsFirst( String::compareTo ) );

    @Override
    public int compareTo( KnightData knightData ) {
        return COMPARATOR.compare( this, knightData );
    }

}
