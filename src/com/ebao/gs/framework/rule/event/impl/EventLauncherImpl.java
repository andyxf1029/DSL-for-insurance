package com.ebao.gs.framework.rule.event.impl;

import java.util.List;

import com.ebao.gs.framework.rule.event.EventHandler;
import com.ebao.gs.framework.rule.event.EventLauncher;
import com.ebao.gs.framework.rule.event.EventValidater;
import com.ebao.gs.framework.rule.event.ResultHandler;
import com.ebao.gs.framework.rule.event.RuntimeEventSender;
import com.ebao.gs.framework.rule.event.bean.Event;
import com.ebao.gs.framework.rule.event.bean.Result;

public class EventLauncherImpl implements EventLauncher {

	private EventValidater validater;

	private List<EventHandler> handlers;

	private RuntimeEventSender runtimeSender;

	private ResultHandler resultHandler;

	public void setValidater(EventValidater validater) {
		this.validater = validater;
	}

	public void setHandlers(List<EventHandler> handlers) {
		this.handlers = handlers;
	}

	public void setRuntimeSender(RuntimeEventSender runtimeSender) {
		this.runtimeSender = runtimeSender;
	}

	public void setResultHandler(ResultHandler resultHandler) {
		this.resultHandler = resultHandler;
	}

	public Result launch(Event event) throws Exception {
		return launchIn(event);
	}

	private Result launchIn(Event event) throws Exception {
		validater.validate(event);
		this.runEventHandlers(event);
		Result result = runtimeSender.send(event);
		return resultHandler.process(result);
	}

	private void runEventHandlers(Event event) {
		if (this.handlers != null && !this.handlers.isEmpty()) {
			for (EventHandler handler : handlers) {
				handler.process(event);
			}
		}
	}

	public void launchEventAsyn(Event event) {
		// TODO Auto-generated method stub

	}

}
