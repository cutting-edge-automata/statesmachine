package com.cutting.edge.automata.builder;

import com.cutting.edge.automata.event.AbstractEvent;
import com.cutting.edge.automata.statesmachine.StatesMachine;

public class EventBuilder extends StatesMachineBuilder {

	public EventBuilder(StatesMachine machine) {
		this.machine = machine;
	}

	public EventBuilder withEvent(String eventName) {
		machine.getEvents().add(new AbstractEvent(eventName));
		return this;
	}
}
