
		StatesMachineBuilder builder = StatesMachineBuilder.of(StatesMachineType.FINITE_AUTOMATA);
		FAStatesMachine machine = (FAStatesMachine) builder.withName("Finite Automata")
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

    Output -> 
    
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q0 on a
    Transition completed from Q0 to Q1 on b
    Transition completed from Q1 to Q1 on b
    Transition completed from Q1 to Q1 on b
    Transition completed from Q1 to Q1 on b
    Transition completed from Q1 to Q1 on b
    Transition completed from Q1 to Q1 on b
    Transition completed from Q1 to Q1 on b
    Transition completed from Q1 to Q1 on b
    Transition completed from Q1 to Q1 on b
    Transition completed from Q1 to Q1 on b
    Transition completed from Q1 to Q1 on b
    Transition completed from Q1 to QF on !

