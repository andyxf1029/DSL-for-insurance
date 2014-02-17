package com.ebao.gs.framework.rule.impl;

import groovy.lang.GroovyObject;

import java.util.HashMap;
import java.util.Map;

import com.ebao.gs.framework.rule.IBaseScriptloader;
import com.ebao.gs.framework.rule.RuleEngine;
import com.ebao.gs.framework.rule.bean.Rule;
import com.ebao.gs.framework.rule.bean.RuleResult;
import com.ebao.gs.framework.rule.service.adapter.IServiceAdapter;
import com.ebao.gs.framework.rule.service.context.IContextDataServiceWarpper;

public class RuleEngineImpl implements RuleEngine {

	private static final String EXTER_SERVICE = "exterService";

	private static final String DATA_SERVICE = "dataService";

	private IBaseScriptloader scriptLoader;

	private IServiceAdapter adapter;

	private IContextDataServiceWarpper dataService;

	private static Map<String, GroovyObject> cache = new HashMap<String, GroovyObject>();

	public void setScriptLoader(IBaseScriptloader scriptLoader) {
		this.scriptLoader = scriptLoader;
	}

	public void setAdapter(IServiceAdapter adapter) {
		this.adapter = adapter;
	}

	public void setDataService(IContextDataServiceWarpper dataService) {
		this.dataService = dataService;
	}

	public RuleResult run(Rule rule, Map<String, Object> context)
			throws Exception {
		// TODO cache base script
		
		
		GroovyObject baseScript;
		if (cache.get("baseScript") != null) {
			baseScript = cache.get("baseScript");
		} else {
			baseScript = scriptLoader.loadBaseScript();
			cache.put("baseScript", baseScript);
		}

		baseScript.setProperty(DATA_SERVICE, dataService);

		
		// TODO cache rule
		GroovyObject ruleScript;
		if (cache.get("ruleScript") != null) {
			ruleScript = cache.get("ruleScript");
		} else {
			ruleScript = scriptLoader.loadScript(rule.getPath());
			cache.put("ruleScript", baseScript);
		}
		ruleScript.setProperty(EXTER_SERVICE, adapter);
		
		
		Object[] args = { ruleScript, context };
		baseScript.invokeMethod("run", args);
		RuleResult result = new RuleResult();
		return result;
	}
}
