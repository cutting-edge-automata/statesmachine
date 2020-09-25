package com.cutting.edge.automata.statesmachine;

import java.util.HashSet;
import java.util.Set;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.transition.Transition;

public abstract class AbstractStatesMachine implements StatesMachine {

	private String name;
	private State currentState;
	private final Set<State> states = new HashSet<State>();
	private final Set<Event> events = new HashSet<Event>();
	private final Set<Transition> transitions = new HashSet<Transition>();

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	@Override
	public Set<State> getStates() {
		return states;
	}

	@Override
	public Set<Event> getEvents() {
		return events;
	}

	@Override
	public Set<Transition> getTransitions() {
		return transitions;
	}

}
