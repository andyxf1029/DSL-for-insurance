package com.ebao.gs.framework.rule.event.impl;

import java.util.List;
import java.util.Map;

import com.ebao.gs.framework.rule.ResultBuilder;
import com.ebao.gs.framework.rule.RuleAgent;
import com.ebao.gs.framework.rule.RuleManagementService;
import com.ebao.gs.framework.rule.bean.Rule;
import com.ebao.gs.framework.rule.event.RuntimeEventSender;
import com.ebao.gs.framework.rule.event.bean.Event;
import com.ebao.gs.framework.rule.event.bean.Result;

public class RuntimeEventSenderImpl implements RuntimeEventSender {

	private RuleManagementService ruleManagementService;

	private RuleAgent ruleAgent;

	public Result send(Event event) throws Exception {
		Map<String, List<Rule>> rules = ruleManagementService.findRules(event
				.getData());
		if (rules.isEmpty()) {
			return new ResultBuilder().build();
		} else {
			return this.ruleAgent.run(rules, event.getData());
		}
	}

}
