package com.windwagon.broceliande.race.turf.impl;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.race.turf.ObjectWrapper;
import com.windwagon.broceliande.race.turf.Reference;
import com.windwagon.broceliande.race.turf.Stud;

public abstract class ObjectWrapperImpl<T> implements ObjectWrapper<T> {

	@Autowired
	protected Stud stud;

	protected Reference ref;

	protected T daoObject;

	protected ObjectWrapperImpl(Reference ref, T daoObject) {
		this.ref = ref;
		this.daoObject = daoObject;
	}

	@Override
	public T getDaoObject() {
		return daoObject;
	}

	@Override
	public Date getNow() {
		return ref.getNow();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof ObjectWrapperImpl)) return false;

		return Objects.equals(daoObject, ((ObjectWrapperImpl<?>) obj).daoObject);

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(daoObject);
	}

	@Override
	public String toString() {
		return Objects.toString(daoObject);
	}

}
