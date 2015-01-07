package com.jasonwjones.hyperion.exportparse;

import org.junit.Before;
import org.junit.Test;

public class ParserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMain() throws Exception {
		String filename = getClass().getResource("/dims-output.xml").getFile();
		Parser.main(new String[]{filename, "Year"});
	}

}
