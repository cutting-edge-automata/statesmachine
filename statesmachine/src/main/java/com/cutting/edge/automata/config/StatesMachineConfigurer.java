package com.cutting.edge.automata.config;

import java.io.File;
import java.io.IOException;

import com.cutting.edge.automata.adapter.StatesMachineAdapter;
import com.cutting.edge.automata.config.model.StatesMachineConfig;
import com.cutting.edge.automata.exception.StatesMachineException;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.statesmachine.StatesMachine;
import com.cutting.edge.automata.utils.StatesMachineConstant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StatesMachineConfigurer {

	public StatesMachine config(String filePath) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		File file = new File(filePath);
		StatesMachineConfig machineConfig = mapper.readValue(file, StatesMachineConfig.class);
		StatesMachine machine = new StatesMachine();
		machine.setName(machineConfig.getName());
		machine.getStates().addAll(StatesMachineAdapter.configToStates(machineConfig.getStates()));
		machine.getEvents().addAll(StatesMachineAdapter.configToEvents(machineConfig.getEvents()));
		machine.getTransitions().addAll(StatesMachineAdapter.configToTransitions(machineConfig.getTransitions(),
				machine.getStates(), machine.getEvents()));
		State initState = machine.getStates().stream().filter(state -> state.isInitalState()).findFirst().orElseThrow(
				() -> new StatesMachineException(machine.getName() + StatesMachineConstant.INITIAL_STATE_NOT_FOUNT));
		machine.init(initState);
		return machine;

	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String filePath = "D:/Java/Automata/Cuttig Edge Automata/statesmachine/statesmachine/src/main/resources/states-machine.json";
		StatesMachineConfigurer configurer = new StatesMachineConfigurer();
		StatesMachine machine = configurer.config(filePath);
		String input = "aaaaabbb";
		machine.accept(input);
	}

}
