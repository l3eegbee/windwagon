package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "ww_scribe_run" )
public class ScribeRun extends Run implements Comparable<ScribeRun> {

    public static final Comparator<ScribeRun> COMPARATOR =
            Comparator.comparing( ScribeRun::getCycle, Comparator.nullsFirst( Cycle.COMPARATOR ) ).thenComparing(
                    ScribeRun::getScribe,
                    Comparator.nullsFirst( ScribeData.COMPARATOR ) );

    @ManyToOne
    @JoinColumn( name = "scribe" )
    private ScribeData scribe;

    @Override
    public int compareTo( ScribeRun scribeRun ) {
        return COMPARATOR.compare( this, scribeRun );
    }

    /**
     * @return the scribe
     */
    public ScribeData getScribe() {
        return scribe;
    }

    /**
     * @param scribe the scribe to set
     */
    public void setScribe( ScribeData scribe ) {
        this.scribe = scribe;
    }

}
