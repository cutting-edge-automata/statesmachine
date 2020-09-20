package com.cutting.edge.automata.config.model;

public class EventConfig extends AbstractConfig {

	private static final long serialVersionUID = -8046923659480021450L;

	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EventConfig [name=" + name + "]";
	}

}
