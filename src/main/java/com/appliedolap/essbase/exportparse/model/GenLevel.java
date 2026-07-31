package com.appliedolap.essbase.exportparse.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType (XmlAccessType.FIELD)
public class GenLevel {

	@XmlAttribute(name = "number")
	private int number;
	
	@XmlAttribute(name = "name")
	private String name;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
