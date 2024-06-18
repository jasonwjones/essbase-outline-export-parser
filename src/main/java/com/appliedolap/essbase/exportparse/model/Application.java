package com.appliedolap.essbase.exportparse.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "application")
@XmlAccessorType(XmlAccessType.FIELD)
public class Application {

	@XmlAttribute(name = "name")
	private String name;

	@XmlAttribute(name = "product")
	private String product;

	@XmlAttribute(name = "redeployType")
	private String redeployType;

	@XmlAttribute(name = "dimCount")
	private Integer dimCount;

	@XmlElement(name = "validation")
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