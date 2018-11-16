package com.appliedolap.essbase.exportparse;

import org.junit.Before;
import org.junit.Test;

import com.appliedolap.essbase.exportparse.model.Application;
import com.appliedolap.essbase.exportparse.printer.SimpleApplicationPrinter;

public class OutlineXmlReaderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRead() throws Exception {
		OutlineXmlReader reader = new OutlineXmlReader();
		Application application = reader.read(getClass().getResourceAsStream("/Sample_U.Basic.xml"));
		
		SimpleApplicationPrinter.printOutline(application);
	}

}
