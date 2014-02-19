import com.ebao.bean.PolicyCT
import com.ebao.gs.framework.rule.service.context.IContextDataServiceWarpper


def run(closure,context){
	def ruleWarpper = new RuleMethodWarpper();
	ruleWarpper.mergeMethods(closure,context,dataService);
	closure.run()
}





class RuleMethodWarpper {
	IContextDataServiceWarpper dataService

	def mergeMethods(closure,context,dataService){
		this.dataService= dataService

		closure.metaClass.propertyMissing = {String name  ->
			dataService.fetchData(context,name);
		}
		closure.metaClass.update = {String name ,value ->
			dataService.updateValue(context,name,value);
		}

		closure.metaClass.coverage = {String name ->
			PolicyCT ct = new PolicyCT();
			ct.code=name
			def ruleWarpper = new RuleMethodWarpper();
			context.put("currentCtCode",name);
			ruleWarpper.mergeMethods(ct, context,dataService)
			return ct;
		}

		closure.metaClass.coverageArray = {String name ->
			List<PolicyCT> ctList = new ArrayList<PolicyCT> ()
			PolicyCT ct = new PolicyCT();
			ctList.add(ct);
			def ruleWarpper = new RuleMethodWarpper();
			context.put("currentCtCode",name);
			ruleWarpper.mergeMethods(ct, context,dataService)
			return ctList;
		}

		closure.metaClass.sum = {List lists ->


			return lists;
		}


		closure.metaClass.stop = {String code ->
			throw new Exception(code);
		}

		closure.metaClass.warn = {String code -> return code }


		//TODO

		return closure;
	}
}