package com.ebao.gs.framework.rule;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;

import com.ebao.gs.framework.rule.bean.Rule;
import com.ebao.gs.framework.rule.event.bean.Result;

public interface RuleAgent {

	Result run(Map<String, List<Rule>> rules, Map<String, Object> context) throws CompilationFailedException, IOException, Exception;

}
