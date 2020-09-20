package com.cutting.edge.automata.state;

public abstract class AbstractState<S> implements State<S> {

	public final boolean initalState;
	public final boolean finalState;
	public final State<S> state;
	public final String name;
	public final int id;

	public AbstractState(State<S> state, boolean initialState, boolean finalState) {
		this.initalState = initialState;
		this.finalState = finalState;
		this.name = state.toString();
		this.state = state;
		this.id = hashCode();

	}

	public State<S> getState() {
		return state;
	}

	public int getStateId() {
		return id;
	}

	public String getStateName() {
		return name;
	}

	public boolean isInitalState() {
		return initalState;
	}

	public boolean isFinalState() {
		return finalState;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (finalState ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (initalState ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

}
