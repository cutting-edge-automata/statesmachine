package com.cutting.edge.automata.action;

import com.cutting.edge.automata.event.Event;

public class AbstractAction implements Action {

	public final Event event;
	public final String topOfTheStack;

	public AbstractAction(Event event, String topOfTheStack) {
		super();
		this.event = event;
		this.topOfTheStack = topOfTheStack;
	}

}
