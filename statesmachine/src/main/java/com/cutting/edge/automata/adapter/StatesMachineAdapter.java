package com.cutting.edge.automata.adapter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.cutting.edge.automata.config.model.EventConfig;
import com.cutting.edge.automata.config.model.StateConfig;
import com.cutting.edge.automata.config.model.TransitionConfig;
import com.cutting.edge.automata.event.AbstractEvent;
import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.exception.StateNotFoundException;
import com.cutting.edge.automata.state.AbstractState;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.transition.AbstractTransition;
import com.cutting.edge.automata.transition.Transition;

public class StatesMachineAdapter {

	public static Set<State> configToStates(Set<StateConfig> configs) {
		return configs.stream()
				.map(config -> new AbstractState(config.getName(), config.isInitialState(), config.isFinalState()))
				.collect(Collectors.toSet());
	}

	public static Set<Event> configToEvents(Set<EventConfig> configs) {
		return configs.stream().map(config -> new AbstractEvent(config.getName())).collect(Collectors.toSet());
	}

	public static Set<Transition> configToTransitions(Set<TransitionConfig> configs, Set<State> states,
			Set<Event> events) {

		Set<Transition> transitions = new HashSet<Transition>();

		for (TransitionConfig transitionConfig : configs) {
			State source = (State) states.stream()
					.filter(stateConfig -> stateConfig.getStateName().equals(transitionConfig.getSource())).findFirst()
					.get();
			State target = (State) states.stream()
					.filter(stateConfig -> stateConfig.getStateName().equals(transitionConfig.getTarget())).findFirst()
					.get();
			Event event = (Event) events.stream()
					.filter(eventConfig -> eventConfig.getEvent().equals(transitionConfig.getEvent())).findFirst()
					.get();
			transitions.add(new AbstractTransition(source, target, event));
		}

		return transitions;
	}

}
