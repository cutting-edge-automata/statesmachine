package com.cutting.edge.automata.action;

public class StackAction {

	public final String onTop;
	public final String element;

	public StackAction(String onTop, String element) {
		this.onTop = onTop;
		this.element = element;
	}

	public String getOnTop() {
		return onTop;
	}

	public String getElement() {
		return element;
	}

	@Override
	public String toString() {
		return "StackAction [ onTop=" + onTop + ", element=" + element + "]";
	}

	
}
