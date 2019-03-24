package com.windwagon.broceliande.race.entities;

import com.windwagon.logres.getset.*;

import java.util.*;

import javax.persistence.*;

/**
 * Horse id.
 */
@Entity
@Table(name = "ww_horseid")

public class HorseID implements Comparable<HorseID> {

	public static final Comparator<HorseID> COMPARATOR = Comparator.comparing(HorseID::getName);

	@Id
//	@SequenceGenerator(name = "sequence_id", sequenceName = "ww_sequence_id")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id")
//https://stackoverflow.com/a/34705410/2730847
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 30)
	private String name;

	@Temporal(TemporalType.DATE)
	private Date birth;

	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private Sex sex;

	@Temporal(TemporalType.DATE)
	private Date gelding;

	private String father;

	private String mother;

	private Integer fiability;

	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private Breed breed;

	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private Coat coat;

	@Override
	public String toString() {

		String id = Getter.get(HorseID::getId).str(this);
		String name = Getter.get(HorseID::getName).str(this);

		return "horseID #" + id + " [" + name + "]";

	}

	@Override
	public int compareTo(HorseID horseID) {
		return COMPARATOR.compare(this, horseID);
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
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * @return the sex
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	/**
	 * @return the gelding
	 */
	public Date getGelding() {
		return gelding;
	}

	/**
	 * @param gelding the gelding to set
	 */
	public void setGelding(Date gelding) {
		this.gelding = gelding;
	}

	/**
	 * @return the father
	 */
	public String getFather() {
		return father;
	}

	/**
	 * @param father the father to set
	 */
	public void setFather(String father) {
		this.father = father;
	}

	/**
	 * @return the mother
	 */
	public String getMother() {
		return mother;
	}

	/**
	 * @param mother the mother to set
	 */
	public void setMother(String mother) {
		this.mother = mother;
	}

	/**
	 * @return the fiability
	 */
	public Integer getFiability() {
		return fiability;
	}

	/**
	 * @param fiability the fiability to set
	 */
	public void setFiability(Integer fiability) {
		this.fiability = fiability;
	}

	/**
	 * @return the breed
	 */
	public Breed getBreed() {
		return breed;
	}

	/**
	 * @param breed the breed to set
	 */
	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	/**
	 * @return the coat
	 */
	public Coat getCoat() {
		return coat;
	}

	/**
	 * @param coat the coat to set
	 */
	public void setCoat(Coat coat) {
		this.coat = coat;
	}

}
