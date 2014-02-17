package com.ebao.gs.framework.rule;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ebao.gs.framework.rule.bean.Rule;
import com.ebao.gs.framework.rule.impl.BaseScriptLoader;
import com.ebao.gs.framework.rule.impl.RuleEngineImpl;
import com.ebao.gs.framework.rule.service.context.IContextDataServiceWarpper;

public class RuleEngineImplTest {

	@Test
	public void test() throws Exception {

		RuleEngineImpl engince = new RuleEngineImpl();

		IContextDataServiceWarpper mockDataService = mock(IContextDataServiceWarpper.class);

		when(mockDataService.fetchData(anyMap(), anyString())).thenReturn(111);

		engince.setDataService(mockDataService);

		BaseScriptLoader loader = new BaseScriptLoader();

		loader.setBaseScriptPath("src/com/ebao/gs/framework/rule/groovy/RuleWarpper.groovy");

		engince.setScriptLoader(loader);
		Rule rule = new Rule();

		rule.setPath("rule/com/ebao/test/Test.groovy");

		Map<String, Object> context = new HashMap<String, Object>();

		long time = System.currentTimeMillis();

		try{
			Object result = engince.run(rule, context);
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		

		System.out.println("first " + (System.currentTimeMillis() - time));

		// long time2 = System.currentTimeMillis();
		//
		// engince.run(rule, context);
		//
		// System.out.println("time 2 " + (System.currentTimeMillis() - time2));

	}
}
