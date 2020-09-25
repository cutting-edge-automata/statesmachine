package com.cutting.edge.automata.action;

public class StackAction {

	public final String type;
	public final String onTop;
	public final String element;

	public StackAction(String type, String onTop, String element) {
		this.type = type;
		this.onTop = onTop;
		this.element = element;
	}

	public String getType() {
		return type;
	}

	public String getOnTop() {
		return onTop;
	}

	public String getElement() {
		return element;
	}

	@Override
	public String toString() {
		return "StackAction [type=" + type + ", onTop=" + onTop + ", element=" + element + "]";
	}

	
}
