package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;
import java.util.SortedSet;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

@Entity
@Table( name = "ww_brotherhood" )
public class BrotherhoodData extends Task implements Comparable<BrotherhoodData> {

    public static final Comparator<BrotherhoodData> COMPARATOR =
            Comparator.comparing( BrotherhoodData::getName, Comparator.nullsFirst( String::compareTo ) );

    @OneToMany( mappedBy = "brotherhood" )
    @ElementCollection( targetClass = FencingMasterData.class )
    @SortNatural
    private SortedSet<FencingMasterData> fencingMasters;

    @Override
    public int compareTo( BrotherhoodData brotherhood ) {
        return COMPARATOR.compare( this, brotherhood );
    }

    /**
     * @return the fencingMasters
     */
    public SortedSet<FencingMasterData> getFencingMasters() {
        return fencingMasters;
    }

    /**
     * @param fencingMasters the fencingMasters to set
     */
    public void setFencingMasters( SortedSet<FencingMasterData> fencingMasters ) {
        this.fencingMasters = fencingMasters;
    }

}
