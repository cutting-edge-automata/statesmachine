package com.cutting.edge.automata.config.model;

import java.util.Set;

public class TransitionConfig extends AbstractConfig {

	private static final long serialVersionUID = 535908406704327200L;

	public String source;
	public String event;
	public String target;
	public Set<StackActionConfig> actions;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Set<StackActionConfig> getActions() {
		return actions;
	}

	public void setActions(Set<StackActionConfig> actions) {
		this.actions = actions;
	}

}
