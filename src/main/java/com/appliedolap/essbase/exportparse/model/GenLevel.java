package com.appliedolap.essbase.exportparse.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

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
