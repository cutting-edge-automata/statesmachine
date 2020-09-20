package com.cutting.edge.automata.state;

public class AbstractState implements State {

	public final boolean initalState;
	public final boolean finalState;
	public final String name;
	public final int id;

	public AbstractState(String name, boolean initialState, boolean finalState) {
		this.initalState = initialState;
		this.finalState = finalState;
		this.name = name;
		this.id = hashCode();

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
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractState other = (AbstractState) obj;
		if (finalState != other.finalState)
			return false;
		if (id != other.id)
			return false;
		if (initalState != other.initalState)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractState [initalState=" + initalState + ", finalState=" + finalState + ", name=" + name + ", id="
				+ id + "]";
	}
}
