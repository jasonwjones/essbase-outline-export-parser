package com.appliedolap.essbase.exportparse;

import com.appliedolap.essbase.exportparse.model.Member;
import com.appliedolap.essbase.exportparse.util.AbstractApplicationWalkerCallback;
import com.appliedolap.essbase.exportparse.util.ApplicationWalker;
import org.junit.Before;
import org.junit.Test;

import com.appliedolap.essbase.exportparse.model.Application;

public class OutlineXmlReaderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRead() throws Exception {
		OutlineXmlReader reader = new OutlineXmlReader();
		Application application = reader.read(getClass().getResourceAsStream("/Sample_U.Basic.xml"));

		ApplicationWalker.walk(application, new AbstractApplicationWalkerCallback() {
			@Override
			public void member(Member member, int generation) {
				System.out.println(indent(generation) + member.getName());
			}
		});

	}

}