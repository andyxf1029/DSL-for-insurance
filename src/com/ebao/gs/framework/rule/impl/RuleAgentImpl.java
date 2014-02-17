package com.ebao.gs.framework.rule.impl;

import java.util.List;
import java.util.Map;

import com.ebao.gs.framework.rule.RuleAgent;
import com.ebao.gs.framework.rule.RuleResultHandler;
import com.ebao.gs.framework.rule.RuleRuntimeStrategy;
import com.ebao.gs.framework.rule.bean.Rule;
import com.ebao.gs.framework.rule.bean.RuleResult;
import com.ebao.gs.framework.rule.event.bean.Result;

public class RuleAgentImpl implements RuleAgent {

	private RuleResultHandler ruleResultHander;

	private RuleRuntimeStrategy runtimeStrategy;

	public Result run(Map<String, List<Rule>> rulesMap,
			Map<String, Object> context) throws Exception {
		List<RuleResult> ruleResultList = runtimeStrategy
				.run(rulesMap, context);
		return ruleResultHander.handle(ruleResultList);
	}
}
