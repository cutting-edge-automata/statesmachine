package com.cutting.edge.automata.config.model;

import java.util.HashSet;
import java.util.Set;

public class StatesMachineConfig extends AbstractConfig {

	private static final long serialVersionUID = -2528734186192903601L;

	private String name;

	private Set<StateConfig> states = new HashSet<StateConfig>();
	private Set<EventConfig> events = new HashSet<EventConfig>();
	private Set<TransitionConfig> transitions = new HashSet<TransitionConfig>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<StateConfig> getStates() {
		return states;
	}

	public void setStates(Set<StateConfig> states) {
		this.states = states;
	}

	public Set<EventConfig> getEvents() {
		return events;
	}

	public void setEvents(Set<EventConfig> events) {
		this.events = events;
	}

	public Set<TransitionConfig> getTransitions() {
		return transitions;
	}

	public void setTransitions(Set<TransitionConfig> transitions) {
		this.transitions = transitions;
	}


}
