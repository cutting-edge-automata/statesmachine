package com.cutting.edge.automata.builder;

import com.cutting.edge.automata.statesmachine.StatesMachine;

public class StatesMachineBuilder {

	protected StatesMachine machine = new StatesMachine();

	public StatesMachineBuilder() {
	}

	public StatesMachineBuilder(StatesMachine machine) {
		this.machine = machine;
	}

	public StatesMachineBuilder withName(String name) {
		machine.setName(name);
		return new StatesMachineBuilder(machine);
	}

	public StateBuilder states() {
		return new StateBuilder(machine);
	}

	public EventBuilder events() {
		return new EventBuilder(machine);
	}

	public StatesMachine build() {
		return machine;
	}

}
