package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;
import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

@Entity
@Table( name = "ww_component_class" )
public class ComponentClass implements Comparable<ComponentClass> {

    public static final Comparator<ComponentClass> COMPARATOR =
            Comparator.comparing( ComponentClass::getMainClass, Comparator.nullsFirst( String::compareTo ) );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    private String mainClass;

    @Lob
    private String description;

    @CollectionTable( name = "ww_componentclass_types", joinColumns = @JoinColumn( name = "component_class" ) )
    @Column( name = "type", length = 250 )
    @ElementCollection( targetClass = String.class )
    @SortNatural
    private SortedSet<String> types;

    private String officialId;

    @ManyToMany( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinTable(
            name = "ww_componentclass_jarfiles",
            joinColumns = @JoinColumn( name = "component_class" ),
            inverseJoinColumns = @JoinColumn( name = "jarfile" ) )
    @ElementCollection( targetClass = JARFile.class )
    @SortNatural
    private SortedSet<JARFile> jarFiles;

    @Override
    public int compareTo( ComponentClass actorClass ) {
        return COMPARATOR.compare( this, actorClass );
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
     * @return the mainClass
     */
    public String getMainClass() {
        return mainClass;
    }

    /**
     * @param mainClass the mainClass to set
     */
    public void setMainClass( String mainClass ) {
        this.mainClass = mainClass;
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

    /**
     * @return the types
     */
    public SortedSet<String> getTypes() {
        return types;
    }

    /**
     * @param types the types to set
     */
    public void setTypes( SortedSet<String> types ) {
        this.types = types;
    }

    /**
     * @return the officialId
     */
    public String getOfficialId() {
        return officialId;
    }

    /**
     * @param officialId the officialId to set
     */
    public void setOfficialId( String officialId ) {
        this.officialId = officialId;
    }

    /**
     * @return the jarFiles
     */
    public SortedSet<JARFile> getJarFiles() {
        return jarFiles;
    }

    /**
     * @param jarFiles the jarFiles to set
     */
    public void setJarFiles( SortedSet<JARFile> jarFiles ) {
        this.jarFiles = jarFiles;
    }

}
