package com.ebao.gs.framework.rule.event;

import org.junit.Test;

import com.ebao.gs.framework.rule.groovy.DSLRunner;

public class DSLRunnerTest {

	@Test
	public void test() {
		DSLRunner.runDSL("rule/com/ebao/test/Test.groovy");
	}

}
