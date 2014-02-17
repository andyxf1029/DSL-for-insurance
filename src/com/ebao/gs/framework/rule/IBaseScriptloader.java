package com.ebao.gs.framework.rule;

import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

import groovy.lang.GroovyObject;

public interface IBaseScriptloader {

	GroovyObject loadBaseScript() throws CompilationFailedException,
			IOException, InstantiationException, IllegalAccessException;

	GroovyObject loadScript(String rulePath) throws CompilationFailedException,
			IOException, InstantiationException, IllegalAccessException;

}
