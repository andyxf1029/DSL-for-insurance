package com.ebao.gs.framework.rule.event;

import com.ebao.gs.framework.rule.event.bean.Event;
import com.ebao.gs.framework.rule.event.bean.Result;

/**
 * 
 * @author FY
 * 
 *         interface for launch rule event
 */
public interface EventLauncher {

	Result launch(Event event) throws Exception;

	void launchEventAsyn(Event event);

}
