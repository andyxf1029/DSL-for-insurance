package com.ebao.gs.framework.rule;

import java.util.Map;

public interface RuntimeContextBuilder {

	Map<String, Object> build(Map<String, Object> context);

}
