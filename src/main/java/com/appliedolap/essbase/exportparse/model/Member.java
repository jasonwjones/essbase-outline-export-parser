package com.appliedolap.essbase.exportparse.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Member {

	/**
	 * Consolidation type is apparently not set for members with the typical consolidation type of
	 * +, so for simplicity we just default it as needed.
	 */
	public static final String DEFAULT_CONSOLIDATION = "+";

	public static final String DEFAULT_DATA_STORAGE = "Stored";

	@XmlAttribute
	private String name;

	@XmlElement(name = "Member")
	private List<Member> members;

	@XmlAttribute(name = "HierarchyType")
	private String hierarchyType;

	@XmlAttribute(name = "SharedMember")
	@XmlJavaTypeAdapter(YesNoBooleanAdapter.class)
	private Boolean sharedMember;

	@XmlAttribute(name = "DataStorage")
	private String dataStorage = DEFAULT_DATA_STORAGE;

	@XmlAttribute(name = "Consolidation")
	private String consolidation = DEFAULT_CONSOLIDATION;

	@XmlAttribute(name = "VarianceReporting")
	private String varianceReporting;

	@XmlAttribute(name = "TimeBalance")
	private String timeBalance;

	@XmlAttribute(name = "TwoPassCalc")
	private String twoPassCalc;

	@XmlAttribute(name = "StorageCategory")
	private String storageCategory;

	@XmlElement(name = "Alias")
	private List<Alias> aliases;

	@XmlElement(name = "UDA")
	private List<String> udas;

	@XmlElement(name = "MemberFormula")
	private String memberFormula;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public List<String> getUdas() {
		return udas;
	}

	public void setUdas(List<String> udas) {
		this.udas = udas;
	}

	public Boolean isSharedMember() {
		return sharedMember;
	}

	public void setSharedMember(Boolean sharedMember) {
		this.sharedMember = sharedMember;
	}

	public String getDataStorage() {
		return dataStorage;
	}

	public void setDataStorage(String dataStorage) {
		this.dataStorage = dataStorage;
	}

	public List<Alias> getAliases() {
		return aliases;
	}

	public void setAliases(List<Alias> aliases) {
		this.aliases = aliases;
	}

	public String getConsolidation() {
		return consolidation;
	}

	public void setConsolidation(String consolidation) {
		this.consolidation = consolidation;
	}

	public String getHierarchyType() {
		return hierarchyType;
	}

	public void setHierarchyType(String hierarchyType) {
		this.hierarchyType = hierarchyType;
	}

	public String getVarianceReporting() {
		return varianceReporting;
	}

	public void setVarianceReporting(String varianceReporting) {
		this.varianceReporting = varianceReporting;
	}

	public String getTimeBalance() {
		return timeBalance;
	}

	public void setTimeBalance(String timeBalance) {
		this.timeBalance = timeBalance;
	}

	public String getTwoPassCalc() {
		return twoPassCalc;
	}

	public void setTwoPassCalc(String twoPassCalc) {
		this.twoPassCalc = twoPassCalc;
	}

	public String getMemberFormula() {
		return memberFormula;
	}

	public void setMemberFormula(String memberFormula) {
		this.memberFormula = memberFormula;
	}

	public String getStorageCategory() {
		return storageCategory;
	}

	public void setStorageCategory(String storageCategory) {
		this.storageCategory = storageCategory;
	}

	@Override
	public String toString() {
		return name
				+ " [ sharedMember=" + sharedMember + ", "
				+ (!DEFAULT_DATA_STORAGE.equals(dataStorage) ? "dataStorage=" + dataStorage + ", " : "")
				+ "consolidation=" + consolidation
				+  (aliases != null ? ", aliases=" + aliases : "")
				+  (udas != null ? ", udas=" + udas : "")
				+ "]";
	}

}