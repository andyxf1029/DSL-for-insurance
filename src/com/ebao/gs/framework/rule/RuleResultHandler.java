package com.ebao.gs.framework.rule;

import java.util.List;

import com.ebao.gs.framework.rule.bean.RuleResult;
import com.ebao.gs.framework.rule.event.bean.Result;

public interface RuleResultHandler {

	Result handle(List<RuleResult> ruleResultList);

}
