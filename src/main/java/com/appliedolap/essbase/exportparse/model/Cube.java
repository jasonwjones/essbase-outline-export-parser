package com.appliedolap.essbase.exportparse.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

// TODO: Implement databaseSettings (contains bsoSettings)
// TODO: Implement dynamicTimeSeriesSettings
// TODO: Attribute calculation settings
@XmlAccessorType(XmlAccessType.FIELD)
public class Cube {

	@XmlElement(name = "applicationSettings")
	private ApplicationSettings applicationSettings;

	@XmlElement(name = "aliasTables")
	private AliasTables aliasTables;
	
	@XmlElement(name = "attributeSettings")
	private AttributeSettings attributeSettings;
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ApplicationSettings {

		@XmlAttribute(name = "cubeType")
		private String cubeType;

		@XmlAttribute(name = "isUTF8")
		private String isUtf8;

		public String getCubeType() {
			return cubeType;
		}

		public void setCubeType(String cubeType) {
			this.cubeType = cubeType;
		}

		public String getIsUtf8() {
			return isUtf8;
		}

		public void setIsUtf8(String isUtf8) {
			this.isUtf8 = isUtf8;
		}

		@Override
		public String toString() {
			return "ApplicationSettings [cubeType=" + cubeType + ", isUtf8=" + isUtf8 + "]";
		}

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class AliasTables {

		@XmlElement(name = "Table")
		private List<Table> tables;

		@XmlElement(name = "DefaultTable")
		private Table defaultTable;

		@XmlAccessorType(XmlAccessType.FIELD)
		public static class Table {

			@XmlAttribute(name = "name")
			private String name;

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			@Override
			public String toString() {
				return "Table [name=" + name + "]";
			}

		}

		public List<Table> getTables() {
			return tables;
		}

		public void setTables(List<Table> tables) {
			this.tables = tables;
		}

		public Table getDefaultTable() {
			return defaultTable;
		}

		public void setDefaultTable(Table defaultTable) {
			this.defaultTable = defaultTable;
		}

		@Override
		public String toString() {
			return "AliasTables [tables=" + tables + ", defaultTable=" + defaultTable + "]";
		}
		
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class AttributeSettings {
		
		@XmlElement
		private String prefixSuffixValue;
		
		@XmlElement
		private String prefixSuffixFormat;

		public String getPrefixSuffixValue() {
			return prefixSuffixValue;
		}

		public void setPrefixSuffixValue(String prefixSuffixValue) {
			this.prefixSuffixValue = prefixSuffixValue;
		}

		public String getPrefixSuffixFormat() {
			return prefixSuffixFormat;
		}

		public void setPrefixSuffixFormat(String prefixSuffixFormat) {
			this.prefixSuffixFormat = prefixSuffixFormat;
		}
		
	}
	
	public ApplicationSettings getApplicationSettings() {
		return applicationSettings;
	}

	public void setApplicationSettings(ApplicationSettings applicationSettings) {
		this.applicationSettings = applicationSettings;
	}

	public AliasTables getAliasTables() {
		return aliasTables;
	}

	public void setAliasTables(AliasTables aliasTables) {
		this.aliasTables = aliasTables;
	}
}
