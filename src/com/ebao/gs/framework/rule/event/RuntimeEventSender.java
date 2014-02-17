package com.ebao.gs.framework.rule.event;

import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

import com.ebao.gs.framework.rule.event.bean.Event;
import com.ebao.gs.framework.rule.event.bean.Result;

public interface RuntimeEventSender {

	Result send(Event event) throws CompilationFailedException, IOException,
			Exception;

}
