package com.appliedolap.essbase.exportparse;

import com.appliedolap.essbase.exportparse.model.Application;
import com.appliedolap.essbase.exportparse.model.Cube;
import com.appliedolap.essbase.exportparse.model.Dimension;
import com.appliedolap.essbase.exportparse.model.Member;
import com.appliedolap.essbase.exportparse.util.AbstractApplicationWalkerCallback;
import com.appliedolap.essbase.exportparse.util.ApplicationWalker;
import com.appliedolap.essbase.exportparse.util.SingleDimensionCallback;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OutlineXmlReaderTest {

	@Test
	public void readsRepresentativeOutlineData() throws Exception {
		Application application = readSampleOutline();

		assertEquals("Sample_U", application.getName());
		assertEquals("4.0", application.getCsVersion());
		assertEquals("ESSBASE_PRODUCT", application.getProduct());
		assertEquals("full", application.getRedeployType());
		assertEquals(Integer.valueOf(10), application.getDimCount());
		assertEquals(10, application.getDimensions().size());
		assertEquals(Boolean.FALSE, application.getValidation().isSharedBeforePrototype());

		Dimension year = application.getDimensions().get(0);
		assertEquals("Year", year.getName());
		assertEquals("4.0", year.getCsVersion());
		assertEquals(Arrays.asList("History", "Quarter"), generationLevelNames(year));
		assertEquals(4, year.getMembers().size());
		assertEquals("Qtr1", year.getMembers().get(0).getName());
		assertEquals(Arrays.asList("Jan", "Feb", "Mar"), memberNames(year.getMembers().get(0).getMembers()));

		Dimension product = application.getDimensions().get(2);
		assertEquals(Arrays.asList("SKU", "Family"), genLevelNames(product));
		assertEquals(4, product.getAttributeDimensions().size());

		Cube cube = application.getCube();
		assertNotNull(cube);
		assertEquals("BSO", cube.getApplicationSettings().getCubeType());
		assertEquals(Arrays.asList("Default", "Long Names", "ChineseNames", "JapaneseNames", "RussianNames", "GermanNames"), aliasTableNames(cube.getAliasTables().getTables()));
		assertEquals("Default", cube.getAliasTables().getDefaultTable().getName());
		assertEquals("Prefix", cube.getAttributeSettings().getPrefixSuffixValue());
		assertEquals("Parent", cube.getAttributeSettings().getPrefixSuffixFormat());
	}

	@Test
	public void walksMembersDepthFirstWithGenerationNumbers() throws Exception {
		Application application = readSampleOutline();
		List<String> visited = new ArrayList<>();

		ApplicationWalker.walk(application, new AbstractApplicationWalkerCallback() {
			@Override
			public void member(Member member, int generation) {
				visited.add(generation + ":" + member.getName());
			}
		});

		assertEquals(Arrays.asList("0:Year", "1:Qtr1", "2:Jan", "2:Feb", "2:Mar", "1:Qtr2"), visited.subList(0, 6));
		assertEquals("1:10-01-1996", visited.get(visited.size() - 1));
	}

	@Test
	void walksOnlyTheRequestedDimension() throws Exception {
		Application application = readSampleOutline();
		List<String> visited = new ArrayList<>();

		ApplicationWalker.walk(application, new SingleDimensionCallback("Product") {
			@Override
			public void member(Member member, int generation) {
				visited.add(generation + ":" + member.getName());
			}
		});

		assertEquals("0:Product", visited.get(0));
		assertEquals("2:300-30", visited.get(visited.size() - 1));
	}

	@Test
	void honorsDimensionTermination() throws Exception {
		Application application = readSampleOutline();
		List<String> startedDimensions = new ArrayList<>();

		ApplicationWalker.walk(application, new AbstractApplicationWalkerCallback() {
			@Override
			public FileVisitResult startDimension(Dimension dimension) {
				startedDimensions.add(dimension.getName());
				return "Measures".equals(dimension.getName()) ? FileVisitResult.TERMINATE : FileVisitResult.CONTINUE;
			}
		});

		assertEquals(Arrays.asList("Year", "Measures"), startedDimensions);
	}

	@Test
	void rejectsExternalEntities() {
		String xml = "<!DOCTYPE application [<!ENTITY external SYSTEM \"file:///etc/passwd\">]>"
				+ "<application name=\"&external;\"/>";

		assertThrows(OutlineXmlException.class, () -> new OutlineXmlReader().read(
				new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))));
	}

	private Application readSampleOutline() throws Exception {
		try (InputStream inputStream = getClass().getResourceAsStream("/Sample_U.Basic.xml")) {
			assertNotNull(inputStream);
			return new OutlineXmlReader().read(inputStream);
		}
	}

	private List<String> memberNames(List<Member> members) {
		List<String> names = new ArrayList<>();
		for (Member member : members) {
			names.add(member.getName());
		}
		return names;
	}

	private List<String> genLevelNames(Dimension dimension) {
		List<String> names = new ArrayList<>();
		dimension.getGenLevels().forEach(genLevel -> names.add(genLevel.getName()));
		return names;
	}

	private List<String> generationLevelNames(Dimension dimension) {
		List<String> names = new ArrayList<>();
		dimension.getGenerationLevels().forEach(genLevel -> names.add(genLevel.getName()));
		return names;
	}

	private List<String> aliasTableNames(List<Cube.AliasTables.Table> tables) {
		List<String> names = new ArrayList<>();
		for (Cube.AliasTables.Table table : tables) {
			names.add(table.getName());
		}
		return names;
	}

}
