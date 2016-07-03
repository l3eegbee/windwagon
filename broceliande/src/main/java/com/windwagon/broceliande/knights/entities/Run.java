package com.windwagon.broceliande.knights.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class Run {

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "cycle" )
    private Cycle cycle;

    @Column( length = 15 )
    @Enumerated( EnumType.STRING )
    private RunStatus status;

    private Long executionDuration;

    @Lob
    private String serialization;

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
     * @return the cycle
     */
    public Cycle getCycle() {
        return cycle;
    }

    /**
     * @param cycle the cycle to set
     */
    public void setCycle( Cycle cycle ) {
        this.cycle = cycle;
    }

    /**
     * @return the status
     */
    public RunStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus( RunStatus status ) {
        this.status = status;
    }

    /**
     * @return the executionDuration
     */
    public Long getExecutionDuration() {
        return executionDuration;
    }

    /**
     * @param executionDuration the executionDuration to set
     */
    public void setExecutionDuration( Long executionDuration ) {
        this.executionDuration = executionDuration;
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
