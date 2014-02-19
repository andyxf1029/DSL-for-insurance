package com.ebao.gs.framework.rule.impl;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

import com.ebao.gs.framework.rule.IBaseScriptloader;

public class BaseScriptLoader implements IBaseScriptloader {

	private String baseScriptPath;

	public void setBaseScriptPath(String baseScriptPath) {
		this.baseScriptPath = baseScriptPath;
	}

	public GroovyObject loadBaseScript() throws CompilationFailedException,
			IOException, InstantiationException, IllegalAccessException {
		return this.loadScript(this.baseScriptPath);
	}

	public GroovyObject loadScript(String rulePath)
			throws CompilationFailedException, IOException,
			InstantiationException, IllegalAccessException {
		ClassLoader parent = getClass().getClassLoader();
		GroovyClassLoader loader = new GroovyClassLoader(parent);
		Class groovyClass = loader.parseClass(new File(rulePath));
		
		System.out.println(groovyClass.getSimpleName());
		return (GroovyObject) groovyClass.newInstance();
	}

}
