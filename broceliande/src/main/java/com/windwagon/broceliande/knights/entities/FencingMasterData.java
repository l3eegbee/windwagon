package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "ww_fencingmaster" )
public class FencingMasterData extends Task implements Comparable<FencingMasterData> {

    public static final Comparator<FencingMasterData> COMPARATOR =
            Comparator.comparing( FencingMasterData::getName, Comparator.nullsFirst( String::compareTo ) );

    @OneToOne
    @JoinColumn( name = "knight" )
    private KnightData knight;

    @ManyToOne
    @JoinColumn( name = "brotherhood" )
    private BrotherhoodData brotherhood;

    @Override
    public int compareTo( FencingMasterData fencingMasterData ) {
        return COMPARATOR.compare( this, fencingMasterData );
    }

    /**
     * @return the knight
     */
    public KnightData getKnight() {
        return knight;
    }

    /**
     * @param knight the knight to set
     */
    public void setKnight( KnightData knight ) {
        this.knight = knight;
    }

    /**
     * @return the brotherhood
     */
    public BrotherhoodData getBrotherhood() {
        return brotherhood;
    }

    /**
     * @param brotherhood the brotherhood to set
     */
    public void setBrotherhood( BrotherhoodData brotherhood ) {
        this.brotherhood = brotherhood;
    }

}
