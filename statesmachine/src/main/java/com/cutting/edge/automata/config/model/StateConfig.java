package com.cutting.edge.automata.config.model;

public class StateConfig extends AbstractConfig {

	private static final long serialVersionUID = -1456634931379821389L;

	private String name;
	private boolean initialState;
	private boolean finalState;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInitialState() {
		return initialState;
	}

	public void setInitialState(boolean initialState) {
		this.initialState = initialState;
	}

	public boolean isFinalState() {
		return finalState;
	}

	public void setFinalState(boolean finalState) {
		this.finalState = finalState;
	}

	@Override
	public String toString() {
		return "StateConfig [name=" + name + ", initialState=" + initialState + ", finalState=" + finalState + "]";
	}

}
