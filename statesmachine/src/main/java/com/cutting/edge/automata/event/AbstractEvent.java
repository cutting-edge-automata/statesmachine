package com.cutting.edge.automata.event;

public class AbstractEvent implements Event {

	public final String event;

	public AbstractEvent(String event) {
		this.event = event;
	}

	public String getEvent() {
		return event;
	}

	@Override
	public String toString() {
		return "AbstractEvent [event=" + event + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
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
		AbstractEvent other = (AbstractEvent) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		return true;
	}
	
	
}
