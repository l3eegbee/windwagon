package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table( name = "ww_official_knight" )
public class OfficialKnightData extends ActorData implements Comparable<OfficialKnightData> {

    public static final Comparator<OfficialKnightData> COMPARATOR =
            Comparator.comparing( OfficialKnightData::getName, Comparator.nullsFirst( String::compareTo ) );

    @Lob
    private String serialization;

    @Override
    public int compareTo( OfficialKnightData officialKnightData ) {
        return COMPARATOR.compare( this, officialKnightData );
    }

    /**
     * @return the serialization
     */
    public String getSerialization() {
        return serialization;
    }

    /**
     * @param serialization the serialization to set
     */
    public void setSerialization( String serialization ) {
        this.serialization = serialization;
    }

}
