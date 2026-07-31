package com.appliedolap.essbase.exportparse.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "application")
@XmlAccessorType(XmlAccessType.FIELD)
public class Application {

	@XmlAttribute(name = "name")
	private String name;

	@XmlAttribute(name = "csversion")
	private String csVersion;

	@XmlAttribute(name = "product")
	private String product;

	@XmlAttribute(name = "redeployType")
	private String redeployType;

	@XmlAttribute(name = "dimCount")
	private Integer dimCount;

	@XmlElement(name = "Validation")
	private Validation validation = new Validation();

	@XmlElement(name = "cube")
	private Cube cube;

	@XmlElement(name = "Dimension")
	private List<Dimension> dimensions;

	public List<Dimension> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<Dimension> dimensions) {
		this.dimensions = dimensions;
	}

	public Cube getCube() {
		return cube;
	}

	public void setCube(Cube cube) {
		this.cube = cube;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCsVersion() {
		return csVersion;
	}

	public void setCsVersion(String csVersion) {
		this.csVersion = csVersion;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getRedeployType() {
		return redeployType;
	}

	public void setRedeployType(String redeployType) {
		this.redeployType = redeployType;
	}

	public Integer getDimCount() {
		if (dimCount == null && dimensions != null) {
			return dimensions.size();
		}
		return dimCount;
	}

	public void setDimCount(Integer dimCount) {
		this.dimCount = dimCount;
	}

	public Validation getValidation() {
		return validation;
	}

	public void setValidation(Validation validation) {
		this.validation = validation;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Validation {

		@XmlAttribute(name = "sharedBeforePrototype")
		@XmlJavaTypeAdapter(YesNoBooleanAdapter.class)
		private Boolean sharedBeforePrototype;

		public Boolean isSharedBeforePrototype() {
			return sharedBeforePrototype;
		}

		public void setSharedBeforePrototype(Boolean sharedBeforePrototype) {
			this.sharedBeforePrototype = sharedBeforePrototype;
		}

	}

}
