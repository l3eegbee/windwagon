package com.windwagon.broceliande.knights.entities;

import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

@Entity
@Table( name = "ww_component" )
public class ComponentData {

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    private String name;

    @Lob
    private String description;

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "component_class" )
    private ComponentClass componentClass;

    @OneToMany( mappedBy = "component", orphanRemoval = true, cascade = CascadeType.ALL )
    @ElementCollection( targetClass = Constant.class )
    @SortNatural
    private SortedSet<Constant> constants;

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
     * @return the componentClass
     */
    public ComponentClass getComponentClass() {
        return componentClass;
    }

    /**
     * @param componentClass the componentClass to set
     */
    public void setComponentClass( ComponentClass componentClass ) {
        this.componentClass = componentClass;
    }

    /**
     * @return the constants
     */
    public SortedSet<Constant> getConstants() {
        return constants;
    }

    /**
     * @param constants the constants to set
     */
    public void setConstants( SortedSet<Constant> constants ) {
        this.constants = constants;
    }

}
