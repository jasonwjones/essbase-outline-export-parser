package com.jasonwjones.hyperion.exportparse;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.jasonwjones.hyperion.exportparse.model.Application;
import com.jasonwjones.hyperion.exportparse.model.Dimension;
import com.jasonwjones.hyperion.exportparse.model.Member;

public class Parser {

	public static void main(String[] args) throws JAXBException {
		if (args.length != 2) {
			System.err.println("Supply two args: an XML file and the dimension to print");
			System.exit(1);
		}
		
		String filename = args[0];
		String dimToPrint = args[1];
		JAXBContext context = JAXBContext.newInstance(Application.class);
		Application app = (Application) context.createUnmarshaller().unmarshal(new File(filename));
		
		for (Dimension dimension : app.getDimensions()) {
			if (dimension.getName().equalsIgnoreCase(dimToPrint)) {
				System.out.println(dimension.getName());
				printMembers(dimension.getMembers(), 1);
			}
		}
	}
		
	public static void printMembers(List<Member> members, int level) {
		for (Member member : members) {
			System.out.print(space(level * 4));
			System.out.println(member.getName());
			if (member.getMembers() != null) {
				printMembers(member.getMembers(), level + 1);
			}
		}
	}
	
	public static String space(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
	
}
