package com.cutting.edge.automata.transition;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.state.State;

public class FATransition extends AbstractTransition {

	public FATransition(State sourceState, State targetState, Event event) {
		super(sourceState, targetState, event);
	}

}
