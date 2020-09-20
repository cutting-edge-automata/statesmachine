package com.cutting.edge.automata.state;

public class PDAState<S> extends AbstractState<S> {

	public PDAState(State<S> state, boolean initialState, boolean finalState) {
		super(state, initialState, finalState);
	}

}
