package com.ebao.gs.framework.rule.groovy

import com.ebao.gs.framework.rule.service.context.IContextDataServiceWarpper


class DSLRunner {

	def emptyMap = [:]

	def runDSL(dsl){
		use(ScriptCategory,DSLRunnerCategory){
			def dslInstance
			if(emptyMap.get("Rule")!=null){
				println("test")
				dslInstance = emptyMap.get("Rule") ;
			}else{
				dslInstance= new GroovyClassLoader().parseClass(dsl as File).newInstance()
				emptyMap.put("Rule",dslInstance);
			}

			addPropertiesMissingMethod(dslInstance).run();
		}
	}
}




