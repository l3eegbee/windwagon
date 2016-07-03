package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "ww_constant" )
public class Constant implements Comparable<Constant> {

    public static final Comparator<Constant> COMPARATOR =
            Comparator.comparing( Constant::getName, Comparator.nullsFirst( String::compareTo ) );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    private String name;

    @Lob
    private String description;

    @Lob
    private String attribute;

    @Column( name = "type_value", length = 15 )
    @Enumerated( EnumType.STRING )
    private ConstantType type;

    private String constraints;

    @Lob
    private String value;

    @Column( name = "order_value" )
    private Integer order;

    private Boolean finalValue;

    private Boolean hiddenValue;

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "component" )
    private ComponentData component;

    @Override
    public int compareTo( Constant constant ) {
        return COMPARATOR.compare( this, constant );
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
     * @return the attribute
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * @param attribute the attribute to set
     */
    public void setAttribute( String attribute ) {
        this.attribute = attribute;
    }

    /**
     * @return the type
     */
    public ConstantType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType( ConstantType type ) {
        this.type = type;
    }

    /**
     * @return the constraints
     */
    public String getConstraints() {
        return constraints;
    }

    /**
     * @param constraints the constraints to set
     */
    public void setConstraints( String constraints ) {
        this.constraints = constraints;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue( String value ) {
        this.value = value;
    }

    /**
     * @return the order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder( Integer order ) {
        this.order = order;
    }

    /**
     * @return the finalValue
     */
    public Boolean getFinalValue() {
        return finalValue;
    }

    /**
     * @param finalValue the finalValue to set
     */
    public void setFinalValue( Boolean finalValue ) {
        this.finalValue = finalValue;
    }

    /**
     * @return the hiddenValue
     */
    public Boolean getHiddenValue() {
        return hiddenValue;
    }

    /**
     * @param hiddenValue the hiddenValue to set
     */
    public void setHiddenValue( Boolean hiddenValue ) {
        this.hiddenValue = hiddenValue;
    }

    /**
     * @return the component
     */
    public ComponentData getComponent() {
        return component;
    }

    /**
     * @param component the component to set
     */
    public void setComponent( ComponentData component ) {
        this.component = component;
    }

}
