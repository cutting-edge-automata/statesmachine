package com.cutting.edge.automata.utils;

import java.io.IOException;

import com.cutting.edge.automata.builder.StatesMachineBuilder;
import com.cutting.edge.automata.config.StatesMachineConfigurer;
import com.cutting.edge.automata.event.Event;
import com.cutting.edge.automata.event.FAEvent;
import com.cutting.edge.automata.event.PDAEvent;
import com.cutting.edge.automata.statesmachine.FAStatesMachine;
import com.cutting.edge.automata.statesmachine.PDAStatesMachine;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class StatesMachineUtils {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		System.out.println("Testing FA builder approach");
		testBuilder();
		System.out.println("Testing FA Configurer approach");
		testConfigurerFSM();
		System.out.println("Testing PDA Configurer approach");
		testConfigurerPDA();

	}

	private static void testConfigurerFSM() throws JsonParseException, JsonMappingException, IOException {
		String filePath = "D:/Java/Automata/Cuttig Edge Automata/statesmachine/statesmachine/src/main/resources/states-machine.json";
		StatesMachineConfigurer configurer = new StatesMachineConfigurer();
		FAStatesMachine machine = (FAStatesMachine) configurer.configFSM(filePath);
		String input = "aaaaabbb";
		machine.accept(input);
	}

	private static void testConfigurerPDA() throws JsonParseException, JsonMappingException, IOException {
		String filePath = "D:/Java/Automata/Cuttig Edge Automata/statesmachine/statesmachine/src/main/resources/pda-states-machine.json";
		StatesMachineConfigurer configurer = new StatesMachineConfigurer();
		PDAStatesMachine machine = (PDAStatesMachine) configurer.configPDASM(filePath);
		String input = "aaabbb";
		machine.accept(input);
	}

	private static void testBuilder() {

		StatesMachineBuilder builder = StatesMachineBuilder.of(StatesMachineType.FINITE_AUTOMATA);
		FAStatesMachine machine = (FAStatesMachine) builder.withName("Finite Automata").states().initState("Q0")
				.withState("Q1").finalState("QF").events().withEvent("a").withEvent("b").withEvent("!").transitions()
				.withTransition("Q0", "Q0", "a").withTransition("Q0", "Q1", "b").withTransition("Q1", "Q1", "b")
				.withTransition("Q1", "QF", "!").build();

		String inputString = "aaaaaaaaaaabbbbbbb";
		machine.accept(inputString);

	}

}
