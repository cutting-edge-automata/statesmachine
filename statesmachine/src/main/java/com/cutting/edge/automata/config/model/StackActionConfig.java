package com.cutting.edge.automata.config.model;

public class StackActionConfig extends AbstractConfig {

	private static final long serialVersionUID = 4017948588107314836L;
	public String onTop;
	public String element;

	public String getOnTop() {
		return onTop;
	}

	public void setOnTop(String onTop) {
		this.onTop = onTop;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

}
