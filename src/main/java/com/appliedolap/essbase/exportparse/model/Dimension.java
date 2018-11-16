package com.appliedolap.essbase.exportparse.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType (XmlAccessType.FIELD)
public class Dimension extends Member {
	
	@XmlAttribute(name = "csversion")
	private String csVersion;
		
	@XmlElement(name = "AttributeDimension")
	private List<AttributeDimension> attributeDimensions;
	
	@XmlElementWrapper(name = "Levels")
	@XmlElement(name = "GenLevel")
	private List<GenLevel> genLevels;

	@XmlAttribute(name = "StorageCategory")
	private String storageCategory;
	
	@XmlAttribute(name = "dimensionType")
	private String dimensionType;
	
	@XmlAttribute(name = "AttributeType")
	private String attributeType;
	
	public List<AttributeDimension> getAttributeDimensions() {
		return attributeDimensions;
	}

	public void setAttributeDimensions(List<AttributeDimension> attributeDimensions) {
		this.attributeDimensions = attributeDimensions;
	}

	public String getStorageCategory() {
		return storageCategory;
	}

	public void setStorageCategory(String storageCategory) {
		this.storageCategory = storageCategory;
	}

	public List<GenLevel> getGenLevels() {
		return genLevels;
	}

	public void setGenLevels(List<GenLevel> genLevels) {
		this.genLevels = genLevels;
	}

	public String getDimensionType() {
		return dimensionType;
	}

	public void setDimensionType(String dimensionType) {
		this.dimensionType = dimensionType;
	}

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	@Override
	public String toString() {
		return "Dimension " + getName() 
				+ "["
				+ (storageCategory != null ? "storageCategory=" + storageCategory + ", ": "")  
				+ "dimensionType=" + dimensionType 
				+ (attributeType != null ? ", attributeType=" + attributeType : "")
				+  (getAliases() != null ? ", aliases=" + getAliases() : "")
				+ "]";
	}
	
}