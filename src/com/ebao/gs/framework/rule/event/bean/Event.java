package com.ebao.gs.framework.rule.event.bean;

import java.util.Map;

public class Event {

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	private long eventId;

	private Map<String, Object> data;

}
