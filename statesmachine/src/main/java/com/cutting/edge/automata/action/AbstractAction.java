package com.cutting.edge.automata.action;

import com.cutting.edge.automata.event.Event;

public class AbstractAction<E, T> implements Action<E, T> {

	public final Event<E> event;
	public final T topOfTheStack;

	public AbstractAction(Event<E> event, T topOfTheStack) {
		super();
		this.event = event;
		this.topOfTheStack = topOfTheStack;
	}

}
