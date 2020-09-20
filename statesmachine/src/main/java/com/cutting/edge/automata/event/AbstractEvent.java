package com.cutting.edge.automata.event;

public abstract class AbstractEvent<E> {

	public final Event<E> event;

	public AbstractEvent(Event<E> event) {
		this.event = event;
	}

	public Event<E> getState() {
		return event;
	}

}
