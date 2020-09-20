package com.cutting.edge.automata.transition;

import com.cutting.edge.automata.action.Action;
import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.state.State;

public class PDATransition<S, E, T> extends AbstractTransition<S, E, T> {

	private final T topOfStack;
	private Action<E, T> action;

	public PDATransition(State<S> sourceState, State<S> targetState, Event<E> event, T topOfStack) {
		super(sourceState, targetState, event);
		this.topOfStack = topOfStack;
	}

	public Action<E, T> getAction() {
		return action;
	}

	public void setAction(Action<E, T> action) {
		this.action = action;
	}

	public T getTopOfStack() {
		return topOfStack;
	}

	

}
