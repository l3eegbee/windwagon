package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "ww_fencingmaster_run" )
public class FencingMasterRun extends Run implements Comparable<FencingMasterRun> {

    public static final Comparator<FencingMasterRun> COMPARATOR =
            Comparator.comparing( FencingMasterRun::getCycle, Comparator.nullsFirst( Cycle.COMPARATOR ) ).thenComparing(
                    FencingMasterRun::getFencingMaster,
                    Comparator.nullsFirst( FencingMasterData.COMPARATOR ) );

    @ManyToOne
    @JoinColumn( name = "fencingmaster" )
    private FencingMasterData fencingMaster;

    @ManyToOne
    @JoinColumn( name = "brotherhood" )
    private BrotherhoodRun brotherhood;

    @Lob
    private String knightSerialization;

    @Override
    public int compareTo( FencingMasterRun fencingMasterRun ) {
        return COMPARATOR.compare( this, fencingMasterRun );
    }

    /**
     * @return the fencingMaster
     */
    public FencingMasterData getFencingMaster() {
        return fencingMaster;
    }

    /**
     * @param fencingMaster the fencingMaster to set
     */
    public void setFencingMaster( FencingMasterData fencingMaster ) {
        this.fencingMaster = fencingMaster;
    }

    /**
     * @return the brotherhood
     */
    public BrotherhoodRun getBrotherhood() {
        return brotherhood;
    }

    /**
     * @param brotherhood the brotherhood to set
     */
    public void setBrotherhood( BrotherhoodRun brotherhood ) {
        this.brotherhood = brotherhood;
    }

    /**
     * @return the knightSerialization
     */
    public String getKnightSerialization() {
        return knightSerialization;
    }

    /**
     * @param knightSerialization the knightSerialization to set
     */
    public void setKnightSerialization( String knightSerialization ) {
        this.knightSerialization = knightSerialization;
    }

}
