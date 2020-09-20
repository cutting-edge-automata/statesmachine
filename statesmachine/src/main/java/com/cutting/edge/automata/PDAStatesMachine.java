package com.cutting.edge.automata;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.event.PDAEvent;
import com.cutting.edge.automata.exception.EventNotFoundException;
import com.cutting.edge.automata.exception.StateNotFoundException;
import com.cutting.edge.automata.exception.TransitionNotFoundException;
import com.cutting.edge.automata.state.PDAState;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.transition.PDATransition;
import com.cutting.edge.automata.utils.StatesMachineConstant;

public class PDAStatesMachine<S, E, T> {

	private final Set<PDAState<S>> states = new HashSet<PDAState<S>>();
	private final Set<PDAEvent<E>> events = new HashSet<PDAEvent<E>>();
	private final Set<PDATransition<S, E, T>> transitions = new HashSet<PDATransition<S, E, T>>();
	private final Stack<T> stack = new Stack<T>();
	private PDAState<S> currentState;

	public PDAState<S> getCurrentState() {
		return currentState;
	}

	public Set<PDAState<S>> getStates() {
		return states;
	}

	public Set<PDAEvent<E>> getEvents() {
		return events;
	}

	public Set<PDATransition<S, E, T>> getTransitions() {
		return transitions;
	}

	public void init(PDAState<S> initState, T topOfStack) {
		if (states.contains(initState)) {
			currentState = initState;
			stack.push((T) StatesMachineConstant.EOL);
			stack.push(topOfStack);

		} else {
			throw new StateNotFoundException(initState.getStateName());
		}

	}

	public void changeState(PDAEvent<E> event, T oldStack, T newStack) {

		if (getEvents().contains(event) && transitionExist(currentState, event, oldStack)) {
			for (PDATransition<S, E, T> transition : transitions) {
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
			throw new EventNotFoundException(event.toString());
		}
	}

	private boolean transitionExist(PDAState<S> state, PDAEvent<E> event, T oldStack) {
		for (PDATransition<S, E, T> transition : transitions) {
			if (transition.getEvent().equals(event) && transition.getSourceState().equals(currentState)
					&& transition.getTopOfStack().equals(oldStack)) {
				return true;
			}
		}
		throw new TransitionNotFoundException("from " + state + " with " + event);
	}
}
