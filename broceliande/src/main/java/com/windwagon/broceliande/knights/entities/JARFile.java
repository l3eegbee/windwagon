package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "ww_jarfile" )
public class JARFile implements Comparable<JARFile> {

    public static final Comparator<JARFile> COMPARATOR =
            Comparator.comparing( JARFile::getPath, Comparator.nullsFirst( String::compareTo ) );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    @Column( unique = true, nullable = false )
    private String path;

    // hash SHA1
    @Column( length = 250 )
    private String checksum;

    @Column( length = 500 )
    private String description;

    @Override
    public int compareTo( JARFile jarFile ) {
        return COMPARATOR.compare( this, jarFile );
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
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath( String path ) {
        this.path = path;
    }

    /**
     * @return the checksum
     */
    public String getChecksum() {
        return checksum;
    }

    /**
     * @param checksum the checksum to set
     */
    public void setChecksum( String checksum ) {
        this.checksum = checksum;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription( String description ) {
        this.description = description;
    }

}
