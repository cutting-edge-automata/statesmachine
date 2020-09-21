package com.cutting.edge.automata.statesmachine;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.cutting.edge.automata.event.PDAEvent;
import com.cutting.edge.automata.exception.StatesMachineException;
import com.cutting.edge.automata.state.PDAState;
import com.cutting.edge.automata.transition.PDATransition;
import com.cutting.edge.automata.utils.StatesMachineConstant;

public class PDAStatesMachine {

	private final Set<PDAState> states = new HashSet<PDAState>();
	private final Set<PDAEvent> events = new HashSet<PDAEvent>();
	private final Set<PDATransition> transitions = new HashSet<PDATransition>();
	private final Stack<String> stack = new Stack<String>();
	private PDAState currentState;

	public PDAState getCurrentState() {
		return currentState;
	}

	public Set<PDAState> getStates() {
		return states;
	}

	public Set<PDAEvent> getEvents() {
		return events;
	}

	public Set<PDATransition> getTransitions() {
		return transitions;
	}

	public void init(PDAState initState, String topOfStack) {
		if (states.contains(initState)) {
			currentState = initState;
			stack.push(StatesMachineConstant.EOL);
			stack.push(topOfStack);
		} else {
			throw new StatesMachineException(initState.getStateName() + StatesMachineConstant.STATE_NOT_FOUND);
		}

	}

	public void changeState(PDAEvent event, String oldStack, String newStack) {

		if (getEvents().contains(event) && transitionExist(currentState, event, oldStack)) {
			for (PDATransition transition : transitions) {
				if (transition.getEvent().equals(event) && transition.getSourceState().equals(currentState)
						&& transition.getTopOfStack().equals(oldStack)) {
					if (newStack.equals(StatesMachineConstant.EPSILON) || oldStack.equals(StatesMachineConstant.EPSILON)
							&& stack.peek().equals(StatesMachineConstant.EOL)) {
						System.out.println("Stack poped up with value " + stack.pop());
					} else {
						System.out.println("Stack pushed in with value " + stack.push(newStack));
					}
					transition.log(transition);
				}
			}
		} else {
			throw new StatesMachineException(event.toString() + StatesMachineConstant.EVENT_NOT_FOUND);
		}
	}

	private boolean transitionExist(PDAState state, PDAEvent event, String oldStack) {
		for (PDATransition transition : transitions) {
			if (transition.getEvent().equals(event) && transition.getSourceState().equals(currentState)
					&& transition.getTopOfStack().equals(oldStack)) {
				return true;
			}
		}
		throw new StatesMachineException(
				"from " + state + " with " + event + StatesMachineConstant.TRANSITION_NOT_FOUND);
	}
}
