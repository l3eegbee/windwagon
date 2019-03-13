package com.windwagon.broceliande.race.entities;

import com.windwagon.logres.getset.*;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "ww_jockey")

public class Jockey implements Comparable<Jockey> {

	public static final Comparator<Jockey> COMPARATOR = Comparator.comparing(Jockey::getName);

	@Id
	@SequenceGenerator(name = "sequence_id", sequenceName = "ww_sequence_id")
//https://stackoverflow.com/a/34705410/2730847
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id")
	private Long id;

	@Column(length = 50)
	private String name;

	@Override
	public int compareTo(Jockey jockey) {
		return COMPARATOR.compare(this, jockey);
	}

	@Override
	public String toString() {

		String id = Getter.get(Jockey::getId).str(this);
		String name = Getter.get(Jockey::getName).str(this);

		return "jockey #" + id + " [" + name + "]";

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
	public void setId(Long id) {
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
	public void setName(String name) {
		this.name = name;
	}

}
