package com.cutting.edge.automata.exception;

import com.cutting.edge.automata.utils.StatesMachineConstant;

public class EventNotFoundException extends StatesMachineException {

	private static final long serialVersionUID = 6159639670456639112L;

	public EventNotFoundException(String message) {
		super(message + StatesMachineConstant.EVENT_NOT_FOUND);
	}

}
