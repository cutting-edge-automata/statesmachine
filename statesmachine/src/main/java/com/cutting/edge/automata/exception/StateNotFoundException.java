package com.cutting.edge.automata.exception;

import com.cutting.edge.automata.utils.StatesMachineConstant;

public class StateNotFoundException extends StatesMachineException {

	private static final long serialVersionUID = -3563028209811194539L;

	public StateNotFoundException(String message) {
		super(message + StatesMachineConstant.STATE_NOT_FOUND);
	}

}
