package com.company.model;

public class Rule {
    private final String currentState;
    private final Character currentSymbol;
    private final String newState;
    private final Character newSymbol;
    private final OPERATION operation;

    public Rule(String currentState, Character currentSymbol, String newState, Character newSymbol, OPERATION operation) {
        this.currentState = currentState;
        this.currentSymbol = currentSymbol;
        this.newState = newState;
        this.newSymbol = newSymbol;
        this.operation = operation;
    }

    public String getCurrentState() {
        return currentState;
    }

    public Character getCurrentSymbol() {
        return currentSymbol;
    }

    public String getNewState() {
        return newState;
    }

    public Character getNewSymbol() {
        return newSymbol;
    }

    public OPERATION getOperation() {
        return operation;
    }
}
