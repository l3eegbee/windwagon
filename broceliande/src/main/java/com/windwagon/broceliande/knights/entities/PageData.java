package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "ww_page" )
public class PageData extends ActorData implements Comparable<PageData> {

    public static final Comparator<PageData> COMPARATOR =
            Comparator.comparing( PageData::getName, Comparator.nullsFirst( String::compareTo ) );

    @Override
    public int compareTo( PageData pageData ) {
        return COMPARATOR.compare( this, pageData );
    }

}
