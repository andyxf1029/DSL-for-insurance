package com.ebao.gs.framework.rule.event;

import com.ebao.gs.framework.rule.event.bean.Result;

public interface ResultHandler {

	Result process(Result result);

}
