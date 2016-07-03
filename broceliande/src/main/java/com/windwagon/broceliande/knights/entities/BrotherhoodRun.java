package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;
import java.util.SortedSet;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

@Entity
@Table( name = "ww_brotherhood_run" )
public class BrotherhoodRun extends Run implements Comparable<BrotherhoodRun> {

    public static final Comparator<BrotherhoodRun> COMPARATOR =
            Comparator.comparing( BrotherhoodRun::getCycle, Comparator.nullsFirst( Cycle.COMPARATOR ) ).thenComparing(
                    BrotherhoodRun::getBrotherhood,
                    Comparator.nullsFirst( BrotherhoodData.COMPARATOR ) );

    @ManyToOne
    @JoinColumn( name = "brotherhood" )
    private BrotherhoodData brotherhood;

    @OneToMany( mappedBy = "brotherhood" )
    @ElementCollection( targetClass = FencingMasterRun.class )
    @SortNatural
    private SortedSet<FencingMasterRun> fencingMasters;

    @OneToOne
    @JoinColumn( name = "selected" )
    private FencingMasterRun selected;

    @Override
    public int compareTo( BrotherhoodRun brotherhoodRun ) {
        return COMPARATOR.compare( this, brotherhoodRun );
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

    /**
     * @return the fencingMasters
     */
    public SortedSet<FencingMasterRun> getFencingMasters() {
        return fencingMasters;
    }

    /**
     * @param fencingMasters the fencingMasters to set
     */
    public void setFencingMasters( SortedSet<FencingMasterRun> fencingMasters ) {
        this.fencingMasters = fencingMasters;
    }

    /**
     * @return the selected
     */
    public FencingMasterRun getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected( FencingMasterRun selected ) {
        this.selected = selected;
    }

}
