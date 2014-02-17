package com.ebao.gs.framework.rule.event;

import com.ebao.gs.framework.rule.event.bean.Event;

public interface EventHandler {

	void process(Event event);

}
