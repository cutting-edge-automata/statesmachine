package com.cutting.edge.automata.builder;

import com.cutting.edge.automata.event.FAEvent;
import com.cutting.edge.automata.statesmachine.StatesMachine;

public class EventBuilder extends StatesMachineBuilder {

	public EventBuilder(StatesMachine machine) {
		super(machine);
	}

	public EventBuilder withEvent(String eventName) {
		machine.getEvents().add(new FAEvent(eventName));
		return this;
	}
}
