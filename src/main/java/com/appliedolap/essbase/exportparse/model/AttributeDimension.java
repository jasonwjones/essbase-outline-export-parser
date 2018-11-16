package com.appliedolap.essbase.exportparse.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class AttributeDimension {

	@XmlAttribute(name = "nameRef")
	private String nameRef;
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlAttribute(name = "AttributeType")
	private String type;

	public String getNameRef() {
		return nameRef;
	}

	public void setNameRef(String nameRef) {
		this.nameRef = nameRef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AttributeDimension [nameRef=" + nameRef + ", name=" + name + ", type=" + type + "]";
	}
	
}
