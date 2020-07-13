package com.appliedolap.essbase.exportparse.printer;

import com.appliedolap.essbase.exportparse.model.Application;
import com.appliedolap.essbase.exportparse.model.AttributeDimension;
import com.appliedolap.essbase.exportparse.model.Dimension;
import com.appliedolap.essbase.exportparse.model.Member;

/**
 * Simple utility class used to give a basic print-out of the {@link Application} object.
 * 
 * @author jasonwjones
 *
 */
public class SimpleApplicationPrinter {

	/**
	 * Convenience method that creates a new printer object and prints the given application outline
	 * file
	 * 
	 * @param application the application outline file
	 * @throws Exception if an exception occurs
	 */
	public static void printOutline(Application application) throws Exception {
		new SimpleApplicationPrinter().print(application);
	}

	public void print(Application application) throws Exception {

		System.out.println("Cube:");
		if (application.getCube() != null) {
			System.out.println("    App settings: " + application.getCube().getApplicationSettings());
			System.out.println("    Alias tables: " + application.getCube().getAliasTables());
		}

		for (Dimension dimension : application.getDimensions()) {
			System.out.println(dimension);

			if (dimension.getAttributeDimensions() != null) {
				for (AttributeDimension attributeDimension : dimension.getAttributeDimensions()) {
					System.out.println("    Attribute Dimension: " + attributeDimension);
				}
			}

			if (dimension.getMembers() != null) {
				for (Member member : dimension.getMembers()) {
					printMember(member, 1);
				}
			}
		}

	}

	private static void printMember(Member member, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("    ");
		}
		System.out.println(member);
		// System.out.printf("%s, (%s)%n", member.getName(), member.getDataStorage());

		if (member.getMembers() != null) {
			for (Member childMember : member.getMembers()) {
				printMember(childMember, level + 1);
			}
		}
	}

}
