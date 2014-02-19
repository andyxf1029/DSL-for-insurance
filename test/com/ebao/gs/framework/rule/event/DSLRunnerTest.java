package com.ebao.gs.framework.rule.event;

import org.junit.Test;

import com.ebao.gs.framework.rule.groovy.DSLRunner;
import com.ebao.gs.framework.rule.service.context.impl.DefalueContextDataServiceWarpperImpl;

public class DSLRunnerTest {

	@Test
	public void test() {
		DSLRunner run = new DSLRunner();
		run.runDSL("rule/com/ebao/test/Test.groovy");
	}

}
