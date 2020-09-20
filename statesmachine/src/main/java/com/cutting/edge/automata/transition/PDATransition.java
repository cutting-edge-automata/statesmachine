package com.cutting.edge.automata.transition;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.state.State;

public class PDATransition extends AbstractTransition {

	private final String topOfStack;

	public PDATransition(State sourceState, State targetState, Event event, String topOfStack) {
		super(sourceState, targetState, event);
		this.topOfStack = topOfStack;
	}

	public String getTopOfStack() {
		return topOfStack;
	}

}
