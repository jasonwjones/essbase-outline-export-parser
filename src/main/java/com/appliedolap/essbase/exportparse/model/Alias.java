package com.appliedolap.essbase.exportparse.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Alias {
	
	@XmlAttribute(name = "table")
	private String table;
	
	@XmlValue
	private String alias;

	public Alias() {}
	
	public Alias(String table, String alias) {
		this.table = table;
		this.alias = alias;
	}
	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		return table + " = " + alias;
	}

}
