package com.ebao.gs.framework.rule.groovy

class DSLRunner {
	static runDSL(dsl){
		use(ScriptCategory){
			new GroovyClassLoader().parseClass(dsl as File).newInstance().run();
		}
	}
}


class ScriptCategory {
	static void value(Script self ,String name ){
		println(name)
	}
}

