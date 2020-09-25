package com.cutting.edge.automata.state;

public class AbstractState implements State {

	public final boolean initalState;
	public final boolean finalState;
	public final String name;
	public final int id;

	public AbstractState(boolean initalState, boolean finalState, String name) {

		this.initalState = initalState;
		this.finalState = finalState;
		this.name = name;
		this.id = hashCode();
	}

	@Override
	public boolean isInitalState() {
		return initalState;
	}

	@Override
	public boolean isFinalState() {
		return finalState;
	}

	@Override
	public String getStateName() {
		return name;
	}

	@Override
	public int getStateId() {
		return id;
	}

	@Override
	public String toString() {
		return "AbstractState [initalState=" + initalState + ", finalState=" + finalState + ", name=" + name + ", id="
				+ id + "]";
	}

}
