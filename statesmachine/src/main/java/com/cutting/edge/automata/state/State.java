package com.cutting.edge.automata.state;

public interface State {

	public int getStateId();

	public String getStateName();

	public boolean isInitalState();

	public boolean isFinalState();

}
