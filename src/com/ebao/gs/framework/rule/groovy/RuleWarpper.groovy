import com.ebao.gs.framework.rule.service.context.IContextDataServiceWarpper


def run(closure,context){
	def ruleWarpper = new RuleMethodWarpper();
	ruleWarpper.mergeMethods(closure,context);
	ruleWarpper.dataService=dataService
	closure.run();
}





class RuleMethodWarpper {
	IContextDataServiceWarpper dataService
	
	def mergeMethods(closure,context){
		closure.metaClass.propertyMissing = {String name ->
			dataService.fetchData(context,name);
		}

		closure.metaClass.update = {String name ,value ->
			dataService.updateValue(context,name,value);
		}



		//TODO

		return closure;
	}
}