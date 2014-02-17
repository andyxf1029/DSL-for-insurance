package com.ebao.gs.framework.rule;

import java.util.List;
import java.util.Map;

import com.ebao.gs.framework.rule.bean.Rule;
import com.ebao.gs.framework.rule.bean.RuleLevelDefine;

public interface RuleManagementService {

	Map<String, List<Rule>> findRules(Map<String, Object> data);

	List<RuleLevelDefine> getRuleLevelDefine(Map<String, Object> context);

}
