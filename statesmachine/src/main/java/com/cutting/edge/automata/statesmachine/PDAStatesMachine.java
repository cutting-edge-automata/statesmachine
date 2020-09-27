package com.cutting.edge.automata.statesmachine;

import java.util.Stack;

import com.cutting.edge.automata.action.StackAction;
import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.event.PDAEvent;
import com.cutting.edge.automata.exception.StatesMachineException;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.transition.PDATransition;
import com.cutting.edge.automata.transition.Transition;
import com.cutting.edge.automata.utils.StatesMachineConstant;

public class PDAStatesMachine extends AbstractStatesMachine {

	private final Stack<String> stack = new Stack<String>();

	public void init(State initState, String topOfStack) {
		if (getStates().contains(initState)) {
			setCurrentState(initState);
			stack.push(StatesMachineConstant.EOL);
			stack.push(topOfStack);
		} else {
			throw new StatesMachineException(initState.getStateName() + StatesMachineConstant.STATE_NOT_FOUND);
		}

	}

	public void changeState(Event event) {

		if (getEvents().contains(event) && transitionExist(getCurrentState(), event)) {
			for (Transition transition : getTransitions()) {
				PDATransition pdaTransition = (PDATransition) transition;
				if (pdaTransition.getEvent().equals(event)
						&& pdaTransition.getSourceState().equals(getCurrentState())) {
					StackAction stackAction = pdaTransition.getActions().stream()
							.filter(action -> action.getOnTop().equals(stack.peek())).findFirst()
							.orElseThrow(() -> new StatesMachineException(StatesMachineConstant.STATE_MACHINE_FAILED));

					performTransition(transition.getTargetState(), stackAction);
					transition.log(transition);
					System.out.println("Stack ->  " + stack);
					return;
				}
			}
		} else {
			throw new StatesMachineException(event.toString() + StatesMachineConstant.EVENT_NOT_FOUND);
		}
	}

	private void performTransition(State targetState, StackAction stackAction) {

		setCurrentState(targetState);
		if (stackAction.getElement().equals(StatesMachineConstant.EPSILON))
			stack.pop();
		else
			stack.push(stackAction.getElement());
				
	}


	private boolean transitionExist(State state, Event event) {
		for (Transition transition : getTransitions()) {
			PDATransition pdaTransition = (PDATransition) transition;
			if (pdaTransition.getEvent().equals(event) && pdaTransition.getSourceState().equals(getCurrentState())) {
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
			event = new PDAEvent(String.valueOf(c));
			changeState(event);
		}
		event = new PDAEvent(StatesMachineConstant.EPSILON);
		changeState(event);
		return getCurrentState().isFinalState();
	}
}
