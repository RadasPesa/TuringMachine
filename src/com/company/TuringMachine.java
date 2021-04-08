package com.company;

import com.company.model.Rule;
import com.company.model.Tape;

import java.util.ArrayList;
import java.util.List;

public class TuringMachine {

    private final List<Rule> rules;
    private Tape tape;
    private List<String> states;
    private String startState;
    private String endState;
    private String rejectState;

    private int temporalComplexity;
    private int spatialComplexity;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    private final List<List<Rule>> multipleRules;
    private List<Tape> tapes;

    public TuringMachine(int numberOfTapes) {
        this.rules = new ArrayList<>();
        this.states = new ArrayList<>();
        this.multipleRules = new ArrayList<>();
        for (int i = 0; i < numberOfTapes; i++) {
            multipleRules.add(new ArrayList<>());
        }
        this.temporalComplexity = 0;
        this.spatialComplexity = 0;
    }

    // Turing machine with 1 tape
    public boolean run(Tape inputTape, boolean silentMode) {
        this.tape = new Tape(inputTape);
        String currentState = startState;
        Rule currentRule = null;

        if (!silentMode) {
            printTape(tape);
        } else {
            System.out.println("Turing machine started in silent mode!");
        }


        while (!currentState.equals(endState) && !currentState.equals(rejectState)) {

            boolean ruleFound = false;

            for (Rule rule : rules) {
                if (rule.getCurrentState().equals(currentState) && rule.getCurrentSymbol().equals(tape.getSymbols().get(tape.getHead()))) {
                    ruleFound = true;
                    currentRule = rule;
                    break;
                }
            }

            if (!ruleFound) {
                System.out.println("No rule found! (" + currentState + ", " + tape.getSymbols().get(tape.getHead()) + ") -> ?");
                return false;
            }

            tape.getSymbols().set(tape.getHead(), currentRule.getNewSymbol());
            currentState = currentRule.getNewState();
            tape.moveHead(currentRule.getOperation());

            temporalComplexity++;

            int tmp = 0;
            for (Character symbol : tape.getSymbols()) {
                if (!symbol.equals('#')) {
                    tmp++;
                }
            }
            if (tmp > spatialComplexity) {
                spatialComplexity = tmp;
            }

            if (!silentMode) {
                printTape(tape);
            }
        }

        System.out.println("\nInitial state of the tape:");
        printTape(inputTape);
        System.out.println("\nFinal state of the tape:");
        printTape(tape);

        if (currentState.equals(this.endState)) {
            return true;
        } else {
            System.out.println("Tape is empty!");
            return false;
        }
    }

    // Universal Turing machine (multiple tapes)
    public boolean run(List<Tape> inputTapes, boolean silentMode) {
        this.tapes = new ArrayList<>();
        for (Tape inputTape : inputTapes) {
            tapes.add(new Tape(inputTape));
        }

        String currentState = this.startState;
        List<Rule> currentRules = new ArrayList<>();

        if (!silentMode) {
            int i = 1;
            for (Tape t : tapes) {
                System.out.print("T" + i + ": ");
                printTape(t);
                i++;
            }
        } else {
            System.out.println("Turing machine started in silent mode!");
        }

        while (!currentState.equals(this.endState) && !currentState.equals(this.rejectState)) {
            int i = 0;
            boolean ruleFound = false;

            currentRules.clear();

            // Looking for corresponding rules
            for (Rule rule : multipleRules.get(0)) {
                if (rule.getCurrentState().equals(currentState) && rule.getCurrentSymbol().equals(tapes.get(0).getSymbols().get(tapes.get(0).getHead()))) {
                    for (int k = 1; k < multipleRules.size(); k++) {
                        if (multipleRules.get(k).get(i).getCurrentState().equals(currentState) &&
                                multipleRules.get(k).get(i).getCurrentSymbol().equals(tapes.get(k).getSymbols().get(tapes.get(k).getHead()))) {
                            if (k == (multipleRules.size()-1)) {
                                ruleFound = true;
                                for (List<Rule> multipleRule : multipleRules) {
                                    currentRules.add(multipleRule.get(i));
                                }
                            }
                        } else {
                            break;
                        }
                    }
                }
                i++;
            }

            // Checking whether all corresponding rules were found
            if (!ruleFound) {
                System.out.println("Not all required rules were found!");
                for (Tape t : tapes) {
                    System.out.println("(" + currentState + ", " + t.getSymbols().get(t.getHead()) + ") -> ?");
                }
                return false;
            }

            // Overwriting old symbol with new
            i = 0;
            for (Tape t : tapes) {
                t.getSymbols().set(t.getHead(), currentRules.get(i).getNewSymbol());
                i++;
            }

            // Updating state
            currentState = currentRules.get(0).getNewState();

            // Moving the head
            i = 0;
            for (Tape t : tapes) {
                t.moveHead(currentRules.get(i).getOperation());
                i++;
            }

            i = 1;
            if (!silentMode) {
                for (Tape t : tapes) {
                    System.out.print("T" + i + ": ");
                    printTape(t);
                    i++;
                }
                //tapes.forEach(this::printTape);
            }
        }

        int i = 1;
        System.out.println("\nInitial state of the tapes:");
        for (Tape t : inputTapes) {
            System.out.print("T" + i + ": ");
            printTape(t);
            i++;
        }
        i = 1;
        System.out.println("\nFinal state of the tapes:");
        for (Tape t : tapes) {
            System.out.print("T" + i + ": ");
            printTape(t);
            i++;
        }

        if (currentState.equals(this.endState)) {
            return true;
        } else {
            System.out.println("Machine ended in reject state or tape is empty!");
            return false;
        }
    }

    public void addStates(List<String> states) {
        this.states = states;
    }

    public void setStartState(String state) {
        if (states.contains(state)) {
            this.startState = state;
        } else {
            System.out.println("State " + state + " does not exist.");
        }
    }

    public void setEndState(String state) {
        if (states.contains(state)) {
            this.endState = state;
        } else {
            System.out.println("State " + state + " does not exist.");
        }
    }

    public void addRule(Rule rule) {
        if (!states.contains(rule.getCurrentState()) || !states.contains(rule.getNewState())) {
            System.out.println("Given state " + rule.getCurrentState() + " or " + rule.getNewState() + " does not exist.");
        } else {
            this.rules.add(rule);
        }
    }

    public void addMultipleRule(List<Rule> rules) {
        int i = 0;
        for (List<Rule> multipleRule : multipleRules) {
            multipleRule.add(rules.get(i));
            i++;
        }
    }

    public void setRejectState(String state) {
        if (states.contains(state)) {
            this.rejectState = state;
        } else {
            System.out.println("State " + state + " does not exist.");
        }
    }

    public int getTemporalComplexity() {
        return temporalComplexity;
    }

    public int getSpatialComplexity() {
        return spatialComplexity;
    }

    private void printTape(Tape tape) {
        int i = 0;
        for (Character symbol : tape.getSymbols()) {
            if (tape.getHead() == i) {
                System.out.print(ANSI_RED);
            }
            System.out.print(symbol);
            if (tape.getHead() == i) {
                System.out.print(ANSI_RESET);
            }
            i++;
        }
        System.out.println();
    }
}
