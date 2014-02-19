package com.ebao.gs.framework.rule.service.context.impl;

import java.util.Map;

import com.ebao.gs.framework.rule.service.context.IContextDataServiceWarpper;

public class DefalueContextDataServiceWarpperImpl implements
		IContextDataServiceWarpper {

	@Override
	public Object fetchData(Map<String, Object> context, String name) {
		// TODO Auto-generated method stub
		return "test";
	}

	@Override
	public void updateValue(Map<String, Object> context, String name,
			Object newValue) {
		System.out.println("update  : " + newValue);
	}

}
