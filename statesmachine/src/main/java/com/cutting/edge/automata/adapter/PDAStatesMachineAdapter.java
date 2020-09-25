package com.cutting.edge.automata.adapter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.Action;

import com.cutting.edge.automata.action.StackAction;
import com.cutting.edge.automata.config.model.EventConfig;
import com.cutting.edge.automata.config.model.StateConfig;
import com.cutting.edge.automata.config.model.TransitionConfig;
import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.event.PDAEvent;
import com.cutting.edge.automata.exception.StatesMachineException;
import com.cutting.edge.automata.state.PDAState;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.transition.PDATransition;
import com.cutting.edge.automata.transition.Transition;
import com.cutting.edge.automata.utils.StatesMachineConstant;

public class PDAStatesMachineAdapter {

	public static Set<State> configToStates(Set<StateConfig> configs) {
		return configs.stream()
				.map(config -> new PDAState(config.getName(), config.isInitialState(), config.isFinalState()))
				.collect(Collectors.toSet());
	}

	public static Set<Event> configToEvents(Set<EventConfig> configs) {
		return configs.stream().map(config -> new PDAEvent(config.getName())).collect(Collectors.toSet());
	}

	public static Set<Transition> configToTransitions(Set<TransitionConfig> configs, Set<State> states,
			Set<Event> events) {

		Set<Transition> transitions = new HashSet<Transition>();

		for (TransitionConfig transitionConfig : configs) {
			State source = (State) states.stream()
					.filter(stateConfig -> stateConfig.getStateName().equals(transitionConfig.getSource())).findFirst()
					.orElseThrow(() -> new StatesMachineException(
							transitionConfig.getSource() + StatesMachineConstant.STATE_NOT_FOUND));
			State target = (State) states.stream()
					.filter(stateConfig -> stateConfig.getStateName().equals(transitionConfig.getTarget())).findFirst()
					.orElseThrow(() -> new StatesMachineException(
							transitionConfig.getTarget() + StatesMachineConstant.STATE_NOT_FOUND));
			Event event = (Event) events.stream()
					.filter(eventConfig -> eventConfig.getEvent().equals(transitionConfig.getEvent())).findFirst()
					.orElseThrow(() -> new StatesMachineException(
							transitionConfig.getEvent() + StatesMachineConstant.EVENT_NOT_FOUND));

			PDATransition pdaTransition = new PDATransition(source, target, event);
			pdaTransition.getActions().addAll(transitionConfig.getActions().stream()
					.map(actionCondig -> new StackAction(actionCondig.getType(),actionCondig.getOnTop(), actionCondig.getElement()))
					.collect(Collectors.toSet()));
			
			transitions.add(pdaTransition);
		}

		return transitions;
	}

}
