package com.cutting.edge.automata.builder;

import com.cutting.edge.automata.event.AbstractEvent;
import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.exception.StatesMachineException;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.statesmachine.StatesMachine;
import com.cutting.edge.automata.transition.AbstractTransition;
import com.cutting.edge.automata.utils.StatesMachineConstant;

public class TransitionBuilder extends StatesMachineBuilder {

	public TransitionBuilder(StatesMachine machine) {
		this.machine = machine;
	}

	public TransitionBuilder withTransition(String sourceState, String targetState, String eventName) {
		State source = (State) machine.getStates().stream()
				.filter(stateConfig -> stateConfig.getStateName().equals(sourceState)).findFirst()
				.orElseThrow(() -> new StatesMachineException(sourceState + StatesMachineConstant.STATE_NOT_FOUND));
		State target = (State) machine.getStates().stream()
				.filter(stateConfig -> stateConfig.getStateName().equals(targetState)).findFirst()
				.orElseThrow(() -> new StatesMachineException(targetState + StatesMachineConstant.STATE_NOT_FOUND));
		Event event = (Event) machine.getEvents().stream()
				.filter(eventConfig -> eventConfig.getEvent().equals(eventName)).findFirst()
				.orElseThrow(() -> new StatesMachineException(eventName + StatesMachineConstant.EVENT_NOT_FOUND));
		machine.getTransitions().add(new AbstractTransition(source, target, event));
		return this;
	}
}
