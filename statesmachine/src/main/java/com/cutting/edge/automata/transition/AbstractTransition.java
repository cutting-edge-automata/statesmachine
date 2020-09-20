package com.cutting.edge.automata.transition;

import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.state.State;

public class AbstractTransition<S, E, T> implements Transition<S, E, T> {

	private final State<S> sourceState;
	private final State<S> targetState;
	private final Event<E> event;

	public AbstractTransition(State<S> sourceState, State<S> targetState, Event<E> event) {
		this.sourceState = sourceState;
		this.targetState = targetState;
		this.event = event;
	}

	@Override
	public State<S> getSourceState() {
		return sourceState;
	}

	@Override
	public State<S> getTargetState() {
		return targetState;
	}

	@Override
	public Event<E> getEvent() {
		return event;
	}

	@Override
	public void log(Transition<S, E, T> transition) {
		System.out.println("Transition completed from " + transition.getSourceState() + " to "
				+ transition.getTargetState() + " on " + event);
	}

}
