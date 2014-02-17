package com.ebao.gs.framework.rule;

import java.io.IOException;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;

import com.ebao.gs.framework.rule.bean.Rule;
import com.ebao.gs.framework.rule.bean.RuleResult;

public interface RuleEngine {

	RuleResult run(Rule rule, Map<String, Object> context) throws CompilationFailedException, IOException, Exception;

}
