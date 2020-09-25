package com.cutting.edge.automata.builder;

import com.cutting.edge.automata.exception.StatesMachineException;
import com.cutting.edge.automata.statesmachine.FAStatesMachine;
import com.cutting.edge.automata.statesmachine.PDAStatesMachine;
import com.cutting.edge.automata.statesmachine.StatesMachine;
import com.cutting.edge.automata.utils.StatesMachineConstant;
import com.cutting.edge.automata.utils.StatesMachineType;

public class StatesMachineBuilder {

	protected StatesMachine machine;
	protected StatesMachineType type;

	@SuppressWarnings("unused")
	private StatesMachineBuilder() {
	}

	public static StatesMachineBuilder of(StatesMachineType type) {
		switch (type) {
		case FINITE_AUTOMATA:
			return new StatesMachineBuilder(new FAStatesMachine());
		case PUSHDOWN_AUTOMATA:
			return new StatesMachineBuilder(new PDAStatesMachine());
		default:
			throw new StatesMachineException("Type not defined " + StatesMachineConstant.STATE_MACHINE_FAILED);
		}
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

	public TransitionBuilder transitions() {
		return new TransitionBuilder(machine);
	}

	public StatesMachine build() {
		return machine;
	}

}
