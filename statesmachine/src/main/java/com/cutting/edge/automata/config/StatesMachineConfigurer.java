package com.cutting.edge.automata.config;

import java.io.File;
import java.io.IOException;

import com.cutting.edge.automata.adapter.FAStatesMachineAdapter;
import com.cutting.edge.automata.adapter.PDAStatesMachineAdapter;
import com.cutting.edge.automata.config.model.StatesMachineConfig;
import com.cutting.edge.automata.exception.StatesMachineException;
import com.cutting.edge.automata.state.State;
import com.cutting.edge.automata.statesmachine.FAStatesMachine;
import com.cutting.edge.automata.statesmachine.PDAStatesMachine;
import com.cutting.edge.automata.statesmachine.StatesMachine;
import com.cutting.edge.automata.utils.StatesMachineConstant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StatesMachineConfigurer {

	public StatesMachine configFSM(String filePath) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		File file = new File(filePath);
		StatesMachineConfig machineConfig = mapper.readValue(file, StatesMachineConfig.class);
		FAStatesMachine machine = new FAStatesMachine();
		machine.setName(machineConfig.getName());
		machine.getStates().addAll(FAStatesMachineAdapter.configToStates(machineConfig.getStates()));
		machine.getEvents().addAll(FAStatesMachineAdapter.configToEvents(machineConfig.getEvents()));
		machine.getTransitions().addAll(FAStatesMachineAdapter.configToTransitions(machineConfig.getTransitions(),
				machine.getStates(), machine.getEvents()));
		State initState = machine.getStates().stream().filter(state -> state.isInitalState()).findFirst().orElseThrow(
				() -> new StatesMachineException(machine.getName() + StatesMachineConstant.INITIAL_STATE_NOT_FOUNT));
		machine.init(initState);
		return machine;

	}

	public StatesMachine configPDASM(String filePath) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		File file = new File(filePath);
		StatesMachineConfig machineConfig = mapper.readValue(file, StatesMachineConfig.class);
		PDAStatesMachine machine = new PDAStatesMachine();
		machine.setName(machineConfig.getName());
		machine.getStates().addAll(PDAStatesMachineAdapter.configToStates(machineConfig.getStates()));
		machine.getEvents().addAll(PDAStatesMachineAdapter.configToEvents(machineConfig.getEvents()));
		machine.getTransitions().addAll(PDAStatesMachineAdapter.configToTransitions(machineConfig.getTransitions(),
				machine.getStates(), machine.getEvents()));
		State initState = machine.getStates().stream().filter(state -> state.isInitalState()).findFirst().orElseThrow(
				() -> new StatesMachineException(machine.getName() + StatesMachineConstant.INITIAL_STATE_NOT_FOUNT));
		machine.init(initState, StatesMachineConstant.STACK_INITIALIZER);
		return machine;

	}

}
