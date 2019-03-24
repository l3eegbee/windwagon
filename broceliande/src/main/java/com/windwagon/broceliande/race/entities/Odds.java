package com.windwagon.broceliande.race.entities;

import com.windwagon.logres.date.*;
import com.windwagon.logres.getset.*;

import org.hibernate.annotations.*;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "ww_odds")

public class Odds implements Comparable<Odds> {

	public static final Comparator<Odds> COMPARATOR = Comparator.comparing(Odds::getRace).thenComparing(Odds::getDate);

	@Id
//	@SequenceGenerator(name = "sequence_id", sequenceName = "ww_sequence_id")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id")
//https://stackoverflow.com/a/34705410/2730847
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "race")
	private Race race;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private Double total;

	@OneToMany(mappedBy = "odds", orphanRemoval = true, cascade = CascadeType.ALL)
	@SortNatural
	private SortedSet<Simple> simples;

	@Override
	public String toString() {

		String id = Getter.get(Odds::getId).str(this);

		Race race = Getter.get(Odds::getRace).safe(this);
		Meeting meeting = Getter.get(Race::getMeeting).safe(race);

		String date = Getter.get(Meeting::getDate).then(LazyDate::D).str(meeting);
		String mNum = Getter.get(Meeting::getNumber).str(meeting);
		String rNum = Getter.get(Race::getNumber).str(race);
		String oDate = Getter.get(Odds::getDate).then(LazyDate::M).str(this);

		return "odds #" + id + " " + String.join("-", date, mNum, rNum, oDate);

	}

	@Override
	public int compareTo(Odds odds) {
		return COMPARATOR.compare(this, odds);
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
	 * @return the race
	 */
	public Race getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(Race race) {
		this.race = race;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @return the simples
	 */
	public SortedSet<Simple> getSimples() {
		return simples;
	}

	/**
	 * @param simples the simples to set
	 */
	public void setSimples(SortedSet<Simple> simples) {
		this.simples = simples;
	}

}
