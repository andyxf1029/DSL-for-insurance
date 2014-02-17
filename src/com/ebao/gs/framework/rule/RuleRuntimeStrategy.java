package com.ebao.gs.framework.rule;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;

import com.ebao.gs.framework.rule.bean.Rule;
import com.ebao.gs.framework.rule.bean.RuleResult;

public interface RuleRuntimeStrategy {

	List<RuleResult> run(Map<String, List<Rule>> rulesMap,
			Map<String, Object> context) throws CompilationFailedException,
			IOException, Exception;

}
