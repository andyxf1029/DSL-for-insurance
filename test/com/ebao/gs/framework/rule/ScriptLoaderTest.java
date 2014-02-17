package com.ebao.gs.framework.rule;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;

import java.io.IOException;

import org.codehaus.groovy.ast.builder.AstBuilder;
import org.codehaus.groovy.control.CompilationFailedException;
import org.junit.Test;

import com.ebao.gs.framework.rule.impl.BaseScriptLoader;

public class ScriptLoaderTest {

	@Test
	public void test() throws CompilationFailedException, IOException,
			InstantiationException, IllegalAccessException {

		BaseScriptLoader loader = new BaseScriptLoader();

		loader.setBaseScriptPath("src/com/ebao/gs/framework/rule/groovy/RuleWarpper.groovy");

		System.out.println(loader.loadBaseScript().getClass().getSimpleName());

		GroovyObject test = loader.loadScript("rule/com/ebao/test/Test.groovy");
		
				

	}

}
