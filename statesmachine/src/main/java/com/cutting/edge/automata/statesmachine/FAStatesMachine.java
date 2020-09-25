package com.cutting.edge.automata.statesmachine;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.event.FAEvent;
import com.cutting.edge.automata.exception.StatesMachineException;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.transition.Transition;
import com.cutting.edge.automata.utils.StatesMachineConstant;

public class FAStatesMachine extends AbstractStatesMachine {

	public void init(State initState) {
		if (getStates().contains(initState)) {
			setCurrentState(initState);
		} else {
			throw new StatesMachineException(initState.getStateName() + StatesMachineConstant.STATE_NOT_FOUND);
		}
	}

	public void changeState(Event event) {

		if (getEvents().contains(event) && transitionExist(getCurrentState(), event)) {
			for (Transition transition : getTransitions()) {
				if (transition.getEvent().equals(event) && transition.getSourceState().equals(getCurrentState())) {
					setCurrentState(transition.getTargetState());
					transition.log(transition);
				}
			}
		} else {
			throw new StatesMachineException(event.toString() + StatesMachineConstant.EVENT_NOT_FOUND);
		}
	}

	private boolean transitionExist(State state, Event event) {
		for (Transition transition : getTransitions()) {
			if (transition.getEvent().equals(event) && transition.getSourceState().equals(getCurrentState())) {
				return true;
			}
		}
		throw new StatesMachineException(
				"from " + state + " with " + event + StatesMachineConstant.TRANSITION_NOT_FOUND);
	}

	public boolean accept(String input) {
		char[] inputs = input.toCharArray();
		Event event;
		for (char c : inputs) {
			event = new FAEvent(String.valueOf(c));
			changeState(event);
		}
		event = new FAEvent(StatesMachineConstant.EPSILON);
		changeState(event);
		return getCurrentState().isFinalState();
	}

}
