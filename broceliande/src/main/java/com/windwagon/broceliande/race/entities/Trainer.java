package com.windwagon.broceliande.race.entities;

import android.annotation.*;

import com.windwagon.logres.getset.*;

import java.util.*;

import javax.persistence.*;

@Entity
@Table( name = "ww_trainer" )
@SuppressLint("NewApi")
public class Trainer implements Comparable<Trainer> {

    public static final Comparator<Trainer> COMPARATOR = Comparator.comparing( Trainer::getName );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    @Column( length = 50 )
    private String name;

    @Override
    public String toString() {

        String id = Getter.get( Trainer::getId ).str( this );
        String name = Getter.get( Trainer::getName ).str( this );

        return "trainer #" + id + " [" + name + "]";

    }

    @Override
    public int compareTo( Trainer trainer ) {
        return COMPARATOR.compare( this, trainer );
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId( Long id ) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName( String name ) {
        this.name = name;
    }

}
