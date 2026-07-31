package com.appliedolap.essbase.exportparse;

import com.appliedolap.essbase.exportparse.model.Application;
import com.appliedolap.essbase.exportparse.model.Dimension;
import com.appliedolap.essbase.exportparse.model.Member;
import com.appliedolap.essbase.exportparse.model.YesNoBooleanAdapter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OutlineXmlWriterTest {

	@Test
	public void writesAndReadsKnownModelData() throws Exception {
		Member child = new Member();
		child.setName("Child");
		child.setSharedMember(true);

		Dimension dimension = new Dimension();
		dimension.setName("Account");
		dimension.setMembers(Arrays.asList(child));

		Application application = new Application();
		application.setName("Sample");
		application.setProduct("ESSBASE_PRODUCT");
		application.setDimensions(Arrays.asList(dimension));

		String xml = OutlineXmlWriter.writeToString(application);

		assertTrue(xml.contains("<application"));
		assertTrue(xml.contains("name=\"Sample\""));
		assertTrue(xml.contains("SharedMember=\"Y\""));

		Application roundTripped = new OutlineXmlReader().read(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
		assertEquals("Sample", roundTripped.getName());
		assertEquals("Account", roundTripped.getDimensions().get(0).getName());
		assertEquals(Boolean.TRUE, roundTripped.getDimensions().get(0).getMembers().get(0).isSharedMember());
	}

	@Test
	public void supportsExistingBooleanRepresentations() throws Exception {
		YesNoBooleanAdapter adapter = new YesNoBooleanAdapter();

		assertTrue(adapter.unmarshal("Y"));
		assertTrue(adapter.unmarshal("true"));
		assertTrue(adapter.unmarshal("1"));
		assertFalse(adapter.unmarshal("N"));
		assertFalse(adapter.unmarshal(null));
		assertEquals("Y", adapter.marshal(true));
		assertEquals("N", adapter.marshal(false));
		assertEquals("N", adapter.marshal(null));
	}

}
