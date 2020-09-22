package com.cutting.edge.automata.utils;

import java.io.IOException;

import com.cutting.edge.automata.builder.StatesMachineBuilder;
import com.cutting.edge.automata.config.StatesMachineConfigurer;
import com.cutting.edge.automata.statesmachine.StatesMachine;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class StatesMachineUtils {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		System.out.println("Testing builder approach");
		testBuilder();
		System.out.println("Testing Configurer approach");		
		testConfigurer();
	}

	private static void testConfigurer() throws JsonParseException, JsonMappingException, IOException {
		String filePath = "D:/Java/Automata/Cuttig Edge Automata/statesmachine/statesmachine/src/main/resources/states-machine.json";
		StatesMachineConfigurer configurer = new StatesMachineConfigurer();
		StatesMachine machine = configurer.config(filePath);
		String input = "aaaaabbb";
		machine.accept(input);
	}

	private static void testBuilder() {

		StatesMachineBuilder builder = new StatesMachineBuilder();
		StatesMachine machine = builder.withName("Finite Automata")
									   .states()
									   .initState("Q0")
									   .withState("Q1")
									   .finalState("QF")
									   .events()
									   .withEvent("a")
									   .withEvent("b")
									   .withEvent("!")
									   .transitions()
									   .withTransition("Q0", "Q0", "a")
									   .withTransition("Q0", "Q1", "b")
									   .withTransition("Q1", "Q1", "b")
									   .withTransition("Q1", "QF", "!")
									   .build();

		String inputString = "aaaaaaaaaaabbbbbbb";
		machine.accept(inputString);

	}
}
