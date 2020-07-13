package com.appliedolap.essbase.exportparse;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.appliedolap.essbase.exportparse.model.Application;

public class OutlineXmlWriter {

	public void write(Application application, File file) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Application.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(application, file);
	}
	
}
