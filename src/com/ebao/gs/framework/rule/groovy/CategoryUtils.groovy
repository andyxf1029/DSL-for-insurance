package com.ebao.gs.framework.rule.groovy

import com.ebao.gs.framework.rule.service.context.IContextDataServiceWarpper
import com.ebao.gs.framework.rule.service.context.impl.DefalueContextDataServiceWarpperImpl

@Category(Script)
class ScriptCategory {
	def update(String name) {
		IContextDataServiceWarpper dataService = new DefalueContextDataServiceWarpperImpl();
		dataService.updateValue(null, name,"test")
	}
}


@Category(DSLRunner)
class DSLRunnerCategory {
	
	def addPropertiesMissingMethod(dslInstance){
		dslInstance.metaClass.propertyMissing = { String name  ->
			IContextDataServiceWarpper dataService = new DefalueContextDataServiceWarpperImpl();
			dataService.fetchData(null, name)
		}
		return dslInstance;
	}
}
