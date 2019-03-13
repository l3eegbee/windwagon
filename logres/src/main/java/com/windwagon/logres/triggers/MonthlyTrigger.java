package com.windwagon.logres.triggers;

import com.windwagon.logres.date.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.*;

import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class MonthlyTrigger extends FixRateTrigger {

	@Autowired
	private Clock clock;

	private int day = 0;

	private LocalTime hour;

	public MonthlyTrigger(int day, LocalTime hour) {
		this.day = day;
		this.hour = hour;
	}

	public int getDay() {
		return day;
	}

	public LocalTime getHour() {
		return hour;
	}

	@Override
	public Date nextExecutionTime(TriggerContext triggerContext) {

		LocalDateTime nextTrigger = LocalDate.now(clock).with(TemporalAdjusters.firstDayOfMonth()).plusDays(day - 1).atTime(hour);
		if (nextTrigger.isBefore(LocalDateTime.now(clock))) {
			nextTrigger = nextTrigger.with(TemporalAdjusters.lastDayOfMonth()).plusDays(day);
		}

		return DateConverter.toDate(nextTrigger);

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		MonthlyTrigger other = (MonthlyTrigger) obj;

		if (!Objects.equals(day, other.day)) return false;
		return Objects.equals(hour, other.hour);

	}

	@Override
	public String toString() {
		return "monthly:" + day + ":" + hour;
	}

}
