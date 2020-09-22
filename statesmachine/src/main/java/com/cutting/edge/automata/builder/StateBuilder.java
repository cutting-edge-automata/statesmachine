package com.cutting.edge.automata.builder;

import com.cutting.edge.automata.exception.StatesMachineException;
import com.cutting.edge.automata.state.AbstractState;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.statesmachine.StatesMachine;
import com.cutting.edge.automata.utils.StatesMachineConstant;

public class StateBuilder extends StatesMachineBuilder {

	public StateBuilder(StatesMachine machine) {
		this.machine = machine;
	}

	public StateBuilder withState(String stateName) {
		machine.getStates().add(new AbstractState(stateName, false, false));
		return this;
	}

	public StateBuilder initState(String stateName) {
		if (machine.getStates().stream().filter(state -> state.isInitalState()).count() == 0) {
			State state = new AbstractState(stateName, true, false);
			machine.getStates().add(state);
			machine.setCurrentState(state);
		} else
			throw new StatesMachineException(stateName + StatesMachineConstant.INITIAL_STATE_ALREADY_EXIST);
		return this;
	}

	public StateBuilder finalState(String stateName) {
		if (machine.getStates().stream().filter(state -> state.isFinalState()).count() == 0)
			machine.getStates().add(new AbstractState(stateName, false, true));
		else
			throw new StatesMachineException(stateName + StatesMachineConstant.FINAL_STATE_ALREADY_EXIST);
		return this;
	}
}
