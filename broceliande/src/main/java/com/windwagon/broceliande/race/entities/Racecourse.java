package com.windwagon.broceliande.race.entities;

import com.windwagon.logres.getset.*;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "ww_racecourse")

public class Racecourse implements Comparable<Racecourse> {

	public final static String DEFAULT_COUNTRY = "FRANCE";

	public static final Comparator<Racecourse> COMPARATOR = Comparator.comparing(Racecourse::getName).thenComparing(Racecourse::getCountry);

	@Id
//	@SequenceGenerator(name = "sequence_id", sequenceName = "ww_sequence_id")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id")
//https://stackoverflow.com/a/34705410/2730847
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String name;

	@Column(length = 30)
	private String country;

	@Override
	public String toString() {

		String id = Getter.get(Racecourse::getId).str(this);
		String name = Getter.get(Racecourse::getName).str(this);
		String country = Getter.get(Racecourse::getCountry).str(this);

		return "racecourse #" + id + " [" + name + "(" + country + ")]";

	}

	@Override
	public int compareTo(Racecourse racecourse) {
		return COMPARATOR.compare(this, racecourse);
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

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
