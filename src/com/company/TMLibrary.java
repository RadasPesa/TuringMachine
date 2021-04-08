package com.company;

import com.company.model.OPERATION;
import com.company.model.Rule;

import java.util.List;

public final class TMLibrary {

    private TMLibrary() {}

    public static TuringMachine getLibrary1() {
        TuringMachine tm = new TuringMachine(1);

        List<String> states = List.of("q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9", "q10", "q11", "q12", "q13", "q14", "q15", "q16", "qF", "qR");
        tm.addStates(states);
        tm.setStartState("q0");
        tm.setEndState("qE");
        tm.setRejectState("qR"); // To find out whether the tape is empty

        // Load rules
        {
            tm.addRule(new Rule("q0", 'x', "q1", 'x', OPERATION.R));
            tm.addRule(new Rule("q0", 'y', "q1", 'y', OPERATION.R));
            tm.addRule(new Rule("q0", '#', "qR", '#', OPERATION.S));
            tm.addRule(new Rule("q1", 'x', "q2", 'x', OPERATION.L));
            tm.addRule(new Rule("q1", 'y', "q2", 'y', OPERATION.L));
            tm.addRule(new Rule("q1", '#', "q14", '#', OPERATION.L));
            tm.addRule(new Rule("q14", 'x', "q15", '#', OPERATION.L));
            tm.addRule(new Rule("q14", 'y', "q15", '#', OPERATION.L));
            tm.addRule(new Rule("q15", '#', "q16", '#', OPERATION.L));
            tm.addRule(new Rule("q16", '#', "qE", '1', OPERATION.S));
            tm.addRule(new Rule("q2", 'x', "q3", '#', OPERATION.L));
            tm.addRule(new Rule("q2", 'y', "q3", '#', OPERATION.L));
            tm.addRule(new Rule("q3", '#', "q4", '#', OPERATION.L));
            tm.addRule(new Rule("q4", '#', "q5", '1', OPERATION.R));
            tm.addRule(new Rule("q5", '#', "q5", '#', OPERATION.R));
            tm.addRule(new Rule("q5", 'x', "q6", 'x', OPERATION.R));
            tm.addRule(new Rule("q5", 'y', "q6", 'x', OPERATION.R));
            tm.addRule(new Rule("q6", 'x', "q7", 'x', OPERATION.L));
            tm.addRule(new Rule("q6", 'y', "q7", 'y', OPERATION.L));
            tm.addRule(new Rule("q6", '#', "q11", '#', OPERATION.L));
            tm.addRule(new Rule("q7", 'x', "q8", '#', OPERATION.L));
            tm.addRule(new Rule("q7", 'y', "q8", '#', OPERATION.L));
            tm.addRule(new Rule("q8", '#', "q8", '#', OPERATION.L));
            tm.addRule(new Rule("q8", '1', "q9", '0', OPERATION.L));
            tm.addRule(new Rule("q8", '0', "q10", '1', OPERATION.R));
            tm.addRule(new Rule("q9", '1', "q9", '0', OPERATION.L));
            tm.addRule(new Rule("q9", '0', "q10", '1', OPERATION.R));
            tm.addRule(new Rule("q9", '#', "q10", '1', OPERATION.R));
            tm.addRule(new Rule("q10", '1', "q10", '1', OPERATION.R));
            tm.addRule(new Rule("q10", '0', "q10", '0', OPERATION.R));
            tm.addRule(new Rule("q10", '#', "q5", '#', OPERATION.R));
            tm.addRule(new Rule("q11", 'x', "q12", '#', OPERATION.L));
            tm.addRule(new Rule("q11", 'x', "q12", '#', OPERATION.L));
            tm.addRule(new Rule("q12", '#', "q12", '#', OPERATION.L));
            tm.addRule(new Rule("q12", '1', "q13", '0', OPERATION.L));
            tm.addRule(new Rule("q12", '0', "qE", '1', OPERATION.S));
            tm.addRule(new Rule("q13", '1', "q13", '0', OPERATION.L));
            tm.addRule(new Rule("q13", '#', "qE", '1', OPERATION.S));
            tm.addRule(new Rule("q13", '0', "qE", '1', OPERATION.S));
        }

        return tm;
    }

    public static TuringMachine getLibrary2() {
        TuringMachine tm = new TuringMachine(2);

        List<String> states = List.of("q0", "q1", "q2", "q3", "q4", "qF", "qR");
        tm.addStates(states);
        tm.setStartState("q0");
        tm.setEndState("qF");
        tm.setRejectState("qF");

        // Loading rules
        {
            tm.addMultipleRule(List.of(new Rule("q0", 'a', "q1", '#', OPERATION.R),
                    new Rule("q0", '#', "q1", 'a', OPERATION.R)));
            tm.addMultipleRule(List.of(new Rule("q0", 'b', "q1", '#', OPERATION.R),
                    new Rule("q0", '#', "q1", 'b', OPERATION.R)));
            tm.addMultipleRule(List.of(new Rule("q0", 'c', "q1", '#', OPERATION.R),
                    new Rule("q0", '#', "q1", 'c', OPERATION.R)));

            tm.addMultipleRule(List.of(new Rule("q1", 'a', "q0", '#', OPERATION.R),
                    new Rule("q1", '#', "q0", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q1", 'b', "q0", '#', OPERATION.R),
                    new Rule("q1", '#', "q0", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q1", 'c', "q0", '#', OPERATION.R),
                    new Rule("q1", '#', "q0", '#', OPERATION.S)));

            tm.addMultipleRule(List.of(new Rule("q0", '#', "q2", '#', OPERATION.S),
                    new Rule("q0", '#', "q2", '#', OPERATION.L)));
            tm.addMultipleRule(List.of(new Rule("q1", '#', "q2", '#', OPERATION.S),
                    new Rule("q1", '#', "q2", '#', OPERATION.L)));

            tm.addMultipleRule(List.of(new Rule("q2", '#', "q2", 'a', OPERATION.R),
                    new Rule("q2", 'a', "q2", 'a', OPERATION.L)));
            tm.addMultipleRule(List.of(new Rule("q2", '#', "q2", '#', OPERATION.S),
                    new Rule("q2", 'b', "q2", 'b', OPERATION.L)));
            tm.addMultipleRule(List.of(new Rule("q2", '#', "q2", '#', OPERATION.S),
                    new Rule("q2", 'c', "q2", 'c', OPERATION.L)));

            tm.addMultipleRule(List.of(new Rule("q3", '#', "q3", '#', OPERATION.S),
                    new Rule("q3", 'a', "q3", 'a', OPERATION.R)));
            tm.addMultipleRule(List.of(new Rule("q3", '#', "q3", 'b', OPERATION.R),
                    new Rule("q3", 'b', "q3", 'b', OPERATION.R)));
            tm.addMultipleRule(List.of(new Rule("q3", '#', "q3", '#', OPERATION.S),
                    new Rule("q3", 'c', "q3", 'c', OPERATION.R)));

            tm.addMultipleRule(List.of(new Rule("q4", '#', "q4", '#', OPERATION.S),
                    new Rule("q4", 'a', "q4", '#', OPERATION.L)));
            tm.addMultipleRule(List.of(new Rule("q4", '#', "q4", '#', OPERATION.S),
                    new Rule("q4", 'b', "q4", '#', OPERATION.L)));
            tm.addMultipleRule(List.of(new Rule("q4", '#', "q4", 'c', OPERATION.R),
                    new Rule("q4", 'c', "q4", '#', OPERATION.L)));

            tm.addMultipleRule(List.of(new Rule("q2", '#', "q3", '#', OPERATION.S),
                    new Rule("q2", '#', "q3", '#', OPERATION.R)));
            tm.addMultipleRule(List.of(new Rule("q3", '#', "q4", '#', OPERATION.S),
                    new Rule("q3", '#', "q4", '#', OPERATION.L)));
            tm.addMultipleRule(List.of(new Rule("q4", '#', "qF", '#', OPERATION.S),
                    new Rule("q4", '#', "qF", '#', OPERATION.S)));
        }
        return tm;
    }

    public static TuringMachine getLibrary3() {
        TuringMachine tm = new TuringMachine(3);

        List<String> states = List.of("q0", "q1", "q2", "qF", "qR");
        tm.addStates(states);
        tm.setStartState("q0");
        tm.setEndState("qF");
        tm.setRejectState("qR");

        // Loading rules
        {
            tm.addMultipleRule(List.of(new Rule("q0", '0', "q0", '0', OPERATION.R),
                    new Rule("q0", '1', "q0", '1', OPERATION.R),
                    new Rule("q0", '#', "q0", '#', OPERATION.R)));

        }
        return tm;
    }

    public static TuringMachine getNullLibrary() {
        TuringMachine tm = new TuringMachine(1);

        List<String> states = List.of("q0", "qF", "qR");
        tm.addStates(states);
        tm.setStartState("q0");
        tm.setEndState("qF");
        tm.setRejectState("qR");

        // Loading rules
        {
            tm.addRule(new Rule("q0", '0', "q0", '0', OPERATION.R));
            tm.addRule(new Rule("q0", '1', "q0", '0', OPERATION.R));
            tm.addRule(new Rule("q0", '#', "qF", '#', OPERATION.S));
        }
        return tm;
    }

    public static TuringMachine getSuccessorLibrary() {
        TuringMachine tm = new TuringMachine(1);

        List<String> states = List.of("q0", "q1", "qF", "qR");
        tm.addStates(states);
        tm.setStartState("q0");
        tm.setEndState("qF");
        tm.setRejectState("qR");

        // Loading rules
        {
            tm.addRule(new Rule("q0", '0', "q0", '0', OPERATION.R));
            tm.addRule(new Rule("q0", '1', "q0", '1', OPERATION.R));
            tm.addRule(new Rule("q0", '#', "q1", '#', OPERATION.L));
            tm.addRule(new Rule("q1", '0', "qF", '1', OPERATION.S));
            tm.addRule(new Rule("q1", '1', "q1", '0', OPERATION.L));
            tm.addRule(new Rule("q1", '#', "qF", '1', OPERATION.S));
        }
        return tm;
    }

    public static TuringMachine getPredecessorLibrary() {
        TuringMachine tm = new TuringMachine(1);

        List<String> states = List.of("q0", "q1", "q2", "qF", "qR");
        tm.addStates(states);
        tm.setStartState("q0");
        tm.setEndState("qF");
        tm.setRejectState("qR");

        // Loading rules
        {
            tm.addRule(new Rule("q0", '0', "q0", '0', OPERATION.R));
            tm.addRule(new Rule("q0", '1', "q0", '1', OPERATION.R));
            tm.addRule(new Rule("q0", '#', "q1", '#', OPERATION.L));

            tm.addRule(new Rule("q1", '0', "q1", '1', OPERATION.L));
            tm.addRule(new Rule("q1", '1', "qF", '0', OPERATION.S));
            tm.addRule(new Rule("q1", '#', "q2", '#', OPERATION.R));
            tm.addRule(new Rule("q2", '0', "q2", '0', OPERATION.R));
            tm.addRule(new Rule("q2", '1', "q2", '0', OPERATION.R));
            tm.addRule(new Rule("q2", '#', "qF", '#', OPERATION.S));
        }
        return tm;
    }

    public static TuringMachine getProjectorLibrary() {
        TuringMachine tm = new TuringMachine(3);

        List<String> states = List.of("q0", "q1", "q2", "q3", "q4", "qF", "qR");
        tm.addStates(states);
        tm.setStartState("q0");
        tm.setEndState("qF");
        tm.setRejectState("qR");

        // Loading rules
        {
            // Copy n
            tm.addMultipleRule(List.of(new Rule("q0", '0', "q0", '0', OPERATION.R),
                    new Rule("q0", '#', "q0", '0', OPERATION.R),
                    new Rule("q0", '#', "q0", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q0", '1', "q0", '1', OPERATION.R),
                    new Rule("q0", '#', "q0", '1', OPERATION.R),
                    new Rule("q0", '#', "q0", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q0", '#', "q1", '#', OPERATION.S),
                    new Rule("q0", '#', "q1", '#', OPERATION.L),
                    new Rule("q0", '#', "q1", '#', OPERATION.S)));

            // Loop predecessor
            // Do n-1 (first deduction for indexing from zero)
            tm.addMultipleRule(List.of(new Rule("q1", '#', "q1", '#', OPERATION.S),
                    new Rule("q1", '0', "q1", '1', OPERATION.L),
                    new Rule("q1", '#', "q1", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q1", '#', "q2", '#', OPERATION.S),
                    new Rule("q1", '1', "q2", '0', OPERATION.R),
                    new Rule("q1", '#', "q2", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q1", '#', "q4", '#', OPERATION.R),
                    new Rule("q1", '#', "q4", '#', OPERATION.S),
                    new Rule("q1", '#', "q4", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q2", '#', "q2", '#', OPERATION.S),
                    new Rule("q2", '0', "q2", '0', OPERATION.R),
                    new Rule("q2", '#', "q2", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q2", '#', "q2", '#', OPERATION.S),
                    new Rule("q2", '1', "q2", '1', OPERATION.R),
                    new Rule("q2", '#', "q2", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q2", '#', "q3", '#', OPERATION.R),
                    new Rule("q2", '#', "q3", '#', OPERATION.S),
                    new Rule("q2", '#', "q3", '#', OPERATION.S)));

            // Skip number if n != 0
            tm.addMultipleRule(List.of(new Rule("q3", '0', "q3", '0', OPERATION.R),
                    new Rule("q3", '#', "q3", '#', OPERATION.S),
                    new Rule("q3", '#', "q3", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q3", '1', "q3", '1', OPERATION.R),
                    new Rule("q3", '#', "q3", '#', OPERATION.S),
                    new Rule("q3", '#', "q3", '#', OPERATION.S)));
            tm.addMultipleRule(List.of(new Rule("q3", '#', "q1", '#', OPERATION.S),
                    new Rule("q3", '#', "q1", '#', OPERATION.L),
                    new Rule("q3", '#', "q1", '#', OPERATION.S)));

            // Project number if n == 0
            tm.addMultipleRule(List.of(new Rule("q4", '0', "q4", '0', OPERATION.R),
                    new Rule("q4", '#', "q4", '#', OPERATION.S),
                    new Rule("q4", '#', "q4", '0', OPERATION.R)));
            tm.addMultipleRule(List.of(new Rule("q4", '1', "q4", '1', OPERATION.R),
                    new Rule("q4", '#', "q4", '#', OPERATION.S),
                    new Rule("q4", '#', "q4", '1', OPERATION.R)));
            tm.addMultipleRule(List.of(new Rule("q4", '#', "qF", '#', OPERATION.S),
                    new Rule("q4", '#', "qF", '#', OPERATION.S),
                    new Rule("q4", '#', "qF", '#', OPERATION.S)));
        }
        return tm;
    }

    public static TuringMachine getAdditionLibrary() {
        TuringMachine tm = new TuringMachine(1);

        List<String> states = List.of("q0", "q1", "q2", "q3", "q4", "q5", "qF", "qR");
        tm.addStates(states);
        tm.setStartState("q0");
        tm.setEndState("qF");
        tm.setRejectState("qR"); // To find out whether the tape is empty

        // Load rules
        {
            // Go to the end of the tape (skip first and second number)
            tm.addRule(new Rule("q0", '0', "q0", '0', OPERATION.R));
            tm.addRule(new Rule("q0", '1', "q0", '1', OPERATION.R));
            tm.addRule(new Rule("q0", '#', "q1", '#', OPERATION.R));
            tm.addRule(new Rule("q1", '0', "q1", '0', OPERATION.R));
            tm.addRule(new Rule("q1", '1', "q1", '1', OPERATION.R));
            // Decrement second number by 1
            tm.addRule(new Rule("q1", '#', "q2", '#', OPERATION.L));
            tm.addRule(new Rule("q2", '0', "q2", '1', OPERATION.L));
            tm.addRule(new Rule("q2", '1', "q3", '0', OPERATION.L));
            // End cycle when second number is 0
            tm.addRule(new Rule("q2", '#', "q5", '#', OPERATION.R));
            // Go to the center of the tape (skip the rest of the second number)
            tm.addRule(new Rule("q3", '0', "q3", '0', OPERATION.L));
            tm.addRule(new Rule("q3", '1', "q3", '1', OPERATION.L));
            tm.addRule(new Rule("q3", '#', "q4", '#', OPERATION.L));
            // Increment first number by 1 and loop
            tm.addRule(new Rule("q4", '0', "q0", '1', OPERATION.R));
            tm.addRule(new Rule("q4", '1', "q4", '0', OPERATION.L));
            tm.addRule(new Rule("q4", '#', "q0", '1', OPERATION.R));
            // Deleting second number
            tm.addRule(new Rule("q5", '0', "q5", '#', OPERATION.R));
            tm.addRule(new Rule("q5", '1', "q5", '#', OPERATION.R));
            tm.addRule(new Rule("q5", '#', "qF", '#', OPERATION.S));
            // ? Get to the start of the tape
        }
        return tm;
    }
}
