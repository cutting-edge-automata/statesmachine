package com.cutting.edge.automata;

import java.util.HashSet;
import java.util.Set;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.exception.EventNotFoundException;
import com.cutting.edge.automata.exception.StateNotFoundException;
import com.cutting.edge.automata.exception.TransitionNotFoundException;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.transition.Transition;

public class StatesMachine<S, E, T> {

	private final Set<State<S>> states = new HashSet<State<S>>();
	private final Set<Event<E>> events = new HashSet<Event<E>>();
	private final Set<Transition<S, E, T>> transitions = new HashSet<Transition<S, E, T>>();
	private State<S> currentState;

	public Set<State<S>> getStates() {
		return states;
	}

	public Set<Event<E>> getEvents() {
		return events;
	}

	public Set<Transition<S, E, T>> getTransitions() {
		return transitions;
	}

	public State<S> getCurrentState() {
		return currentState;
	}

	public void init(State<S> initState) {
		if (states.contains(initState)) {
			currentState = initState;
		} else {
			throw new StateNotFoundException(initState.getStateName());
		}
	}

	public void changeState(Event<E> event) {

		if (events.contains(event) && transitionExist(currentState, event)) {
			for (Transition<S, E, T> transition : transitions) {
				if (transition.getEvent().equals(event) && transition.getSourceState().equals(currentState)) {
					currentState = transition.getTargetState();
					transition.log(transition);
				}
			}
		} else {
			throw new EventNotFoundException(event.toString());
		}
	}

	private boolean transitionExist(State<S> state, Event<E> event) {
		for (Transition<S, E, T> transition : transitions) {
			if (transition.getEvent().equals(event) && transition.getSourceState().equals(currentState)) {
				return true;
			}
		}
		throw new TransitionNotFoundException("from " + state + " with " + event);
	}

}
