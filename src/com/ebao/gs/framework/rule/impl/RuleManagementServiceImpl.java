package com.ebao.gs.framework.rule.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ebao.gs.framework.rule.RuleManagementService;
import com.ebao.gs.framework.rule.bean.Rule;
import com.ebao.gs.framework.rule.bean.RuleLevelDefine;

public class RuleManagementServiceImpl implements RuleManagementService {

	@Override
	public Map<String, List<Rule>> findRules(Map<String, Object> data) {
		// TODO Auto-generated method stub

		// TODO Mock

		List<Rule> ruleList = new ArrayList<Rule>();

		Rule rule = new Rule();

		rule.setName("test");

		rule.setPath("rule/com/ebao/test/Test.groovy");

		ruleList.add(rule);

		return null;

	}

	public List<RuleLevelDefine> getRuleLevelDefine(Map<String, Object> context) {
		// TODO Auto-generated method stub
		return null;
	}

}
