package com.cutting.edge.automata.statesmachine;

import java.util.Set;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.transition.Transition;

public interface StatesMachine {

	public void setName(String name);

	public String getName();

	public void setCurrentState(State state);

	public State getCurrentState();

	public Set<State> getStates();

	public Set<Event> getEvents();

	public Set<Transition> getTransitions();

}
