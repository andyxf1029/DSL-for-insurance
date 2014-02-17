package com.ebao.gs.framework.rule.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.ebao.gs.framework.rule.event.bean.Event;
import com.ebao.gs.framework.rule.event.impl.EventLauncherImpl;

public class EventLauncherTest {

	@Test
	public void test() throws Exception {

		EventValidater mockValidater = mock(EventValidater.class);
		EventLauncherImpl launcher = new EventLauncherImpl();
		launcher.setValidater(mockValidater);
		
		
		
		
		
		Event event = new Event();
		launcher.launch(event);

		System.out.println("test");

	}
}
