package com.ebao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.builder.AstBuilder;
import org.junit.Test;

public class TestGroovyAST {

	@Test
	public void test() throws IOException {

		AstBuilder builder = new AstBuilder();

		String fileString = readFile("rule/com/ebao/test/Test.groovy");

		List<ASTNode> nodes = builder.buildFromString(fileString);
		System.out.println(nodes);
		System.out.println();
		
		
		for (ASTNode astNode : nodes) {
		}
		// builder.buildFromString()

	}

	static String readFile(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();

		String ls = System.getProperty("line.separator");

		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}

		return stringBuilder.toString();

	}

}
