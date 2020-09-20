package com.cutting.edge.automata.transition;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.state.State;

public interface Transition<S, E, T> {

	public State<S> getSourceState();

	public State<S> getTargetState();

	public Event<E> getEvent();

	public void log(Transition<S, E, T> transition);
}
