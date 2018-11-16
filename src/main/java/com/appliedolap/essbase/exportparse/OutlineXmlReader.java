package com.appliedolap.essbase.exportparse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.appliedolap.essbase.exportparse.model.Application;

/**
 * Reads an Essbase outline file and returns a JAXB POJO with the contents
 * 
 * @author jasonwjones
 *
 */
public class OutlineXmlReader {

	/**
	 * Read an outline XML file
	 * 
	 * @param file the outline file
	 * @return a new application object
	 * @throws JAXBException if there is an error parsing the file
	 */
	public Application read(File file) throws JAXBException {
		try {
			return read(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Couldn't find file " + file, e);
		}
	}

	/**
	 * Read an outline XML file (stream).
	 * 
	 * @param inputStream the input stream to read
	 * @return a new application object
	 * @throws JAXBException if there is an error parsing the file
	 */
	public Application read(InputStream inputStream) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Application.class);
		return (Application) context.createUnmarshaller().unmarshal(inputStream);
	}

}
