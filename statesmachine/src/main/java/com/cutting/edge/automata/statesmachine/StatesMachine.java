package com.cutting.edge.automata.statesmachine;

import java.util.HashSet;
import java.util.Set;

import com.cutting.edge.automata.event.AbstractEvent;
import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.exception.EventNotFoundException;
import com.cutting.edge.automata.exception.StateNotFoundException;
import com.cutting.edge.automata.exception.StatesMachineException;
import com.cutting.edge.automata.exception.TransitionNotFoundException;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.transition.Transition;
import com.cutting.edge.automata.utils.StatesMachineConstant;

public class StatesMachine {

	private final String name;
	private final Set<State> states = new HashSet<State>();
	private final Set<Event> events = new HashSet<Event>();
	private final Set<Transition> transitions = new HashSet<Transition>();
	private State currentState;

	public StatesMachine(String name) {
		this.name = name;
	}

	public Set<State> getStates() {
		return states;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public Set<Transition> getTransitions() {
		return transitions;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public String getName() {
		return name;
	}

	public void init(State initState) {
		if (states.contains(initState)) {
			currentState = initState;
		} else {
			throw new StateNotFoundException(initState.getStateName());
		}
	}

	public void changeState(Event event) {

		if (events.contains(event) && transitionExist(currentState, event)) {
			for (Transition transition : transitions) {
				if (transition.getEvent().equals(event) && transition.getSourceState().equals(currentState)) {
					currentState = transition.getTargetState();
					transition.log(transition);
				}
			}
		} else {
			throw new EventNotFoundException(event.toString());
		}
	}

	private boolean transitionExist(State state, Event event) {
		for (Transition transition : transitions) {
			if (transition.getEvent().equals(event) && transition.getSourceState().equals(currentState)) {
				return true;
			}
		}
		throw new TransitionNotFoundException("from " + state + " with " + event);
	}

	public boolean accept(String input) {
		char[] inputs = input.toCharArray();
		Event event;
		for (char c : inputs) {
			event = new AbstractEvent(String.valueOf(c));
			changeState(event);
		}
		event = new AbstractEvent(StatesMachineConstant.EPSILON);
		changeState(event);
		return currentState.isFinalState();
	}

}
