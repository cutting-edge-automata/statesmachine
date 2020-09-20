package com.cutting.edge.automata.transition;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.state.State;

public interface Transition {

	public State getSourceState();

	public State getTargetState();

	public Event getEvent();

	public void log(Transition transition);
}
