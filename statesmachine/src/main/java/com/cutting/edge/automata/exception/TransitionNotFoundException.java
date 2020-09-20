package com.cutting.edge.automata.exception;

import com.cutting.edge.automata.utils.StatesMachineConstant;

public class TransitionNotFoundException extends StatesMachineException {

	private static final long serialVersionUID = -2274037564812445507L;

	public TransitionNotFoundException(String message) {
		super(message + StatesMachineConstant.TRANSITION_NOT_FOUND);
	}

}
