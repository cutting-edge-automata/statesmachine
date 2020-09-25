package com.cutting.edge.automata.transition;

import java.util.HashSet;
import java.util.Set;

import com.cutting.edge.automata.action.StackAction;
import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.state.State;

public class PDATransition extends AbstractTransition {

	public final Set<StackAction> actions = new HashSet<StackAction>();

	public PDATransition(State sourceState, State targetState, Event event) {
		super(sourceState, targetState, event);
	}

	public Set<StackAction> getActions() {
		return actions;
	}

	@Override
	public String toString() {
		return "PDATransition [event=" + getEvent() + " actions=" + actions + "]";
	}

}
