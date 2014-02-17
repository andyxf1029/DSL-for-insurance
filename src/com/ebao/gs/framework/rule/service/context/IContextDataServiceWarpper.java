package com.ebao.gs.framework.rule.service.context;

import java.util.Map;

public interface IContextDataServiceWarpper {

	Object fetchData(Map<String, Object> context, String name);

	void updateValue(Map<String, Object> context, String name, Object newValue);

}
