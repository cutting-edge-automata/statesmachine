package com.cutting.edge.automata.transition;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.state.State;

public class AbstractTransition implements Transition {

	private final State sourceState;
	private final State targetState;
	private final Event event;

	public AbstractTransition(State sourceState, State targetState, Event event) {
		this.sourceState = sourceState;
		this.targetState = targetState;
		this.event = event;
	}

	@Override
	public State getSourceState() {
		return sourceState;
	}

	@Override
	public State getTargetState() {
		return targetState;
	}

	@Override
	public Event getEvent() {
		return event;
	}

	@Override
	public void log(Transition transition) {
		System.out.println("Transition completed from " + transition.getSourceState().getStateName() + " to "
				+ transition.getTargetState().getStateName() + " on " + event.getEvent());
	}

	@Override
	public String toString() {
		return "AbstractTransition [sourceState=" + sourceState + ", targetState=" + targetState + ", event=" + event
				+ "]";
	}

}
