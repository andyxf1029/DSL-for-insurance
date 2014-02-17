package com.ebao.gs.framework.rule.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;
import org.springframework.util.CollectionUtils;

import com.ebao.gs.framework.rule.RuleContextBuilderFactory;
import com.ebao.gs.framework.rule.RuleEngine;
import com.ebao.gs.framework.rule.RuleManagementService;
import com.ebao.gs.framework.rule.RuleRuntimeStrategy;
import com.ebao.gs.framework.rule.RuntimeContextBuilder;
import com.ebao.gs.framework.rule.bean.Rule;
import com.ebao.gs.framework.rule.bean.RuleLevelDefine;
import com.ebao.gs.framework.rule.bean.RuleResult;

public class RuleRuntimeStrategyImpl implements RuleRuntimeStrategy {

	private RuleManagementService ruleManagment;

	private RuleContextBuilderFactory runtimeBuilderFactory;

	private RuleEngine engine;

	@Override
	public List<RuleResult> run(Map<String, List<Rule>> rulesMap,
			Map<String, Object> context) throws CompilationFailedException,
			IOException, Exception {
		List<RuleResult> ruleResultList = new ArrayList<RuleResult>();
		List<RuleLevelDefine> ruleLevelDefinceList = ruleManagment
				.getRuleLevelDefine(context);
		for (RuleLevelDefine levelDefine : ruleLevelDefinceList) {
			List<Rule> rules = rulesMap.get(levelDefine.getLevelName());
			if (!CollectionUtils.isEmpty(rules)) {
				RuntimeContextBuilder builder = runtimeBuilderFactory
						.getBuilder(levelDefine);
				for (Rule rule : rules) {
					RuleResult result = engine
							.run(rule, builder.build(context));
					ruleResultList.add(result);
				}
			}
		}

		return ruleResultList;
	}

}
