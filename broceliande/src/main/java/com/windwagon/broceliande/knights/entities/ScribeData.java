package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "ww_scribe" )
public class ScribeData extends Task implements Comparable<ScribeData> {

    public static final Comparator<ScribeData> COMPARATOR =
            Comparator.comparing( ScribeData::getName, Comparator.nullsFirst( String::compareTo ) );

    @Override
    public int compareTo( ScribeData scribe ) {
        return COMPARATOR.compare( this, scribe );
    }

}
