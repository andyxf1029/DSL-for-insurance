package com.ebao.gs.framework.rule;

import com.ebao.gs.framework.rule.bean.RuleLevelDefine;

public interface RuleContextBuilderFactory {

	RuntimeContextBuilder getBuilder(RuleLevelDefine levelDefine);

}
