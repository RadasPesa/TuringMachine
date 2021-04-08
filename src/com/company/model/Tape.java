package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Tape {
    private final List<Character> symbols;
    private int head;

    public Tape(String input) {
        this.symbols = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            symbols.add(input.charAt(i));
        }

        this.head = 0;
        for (Character symbol : symbols) {
            if (symbol == '#') {
                head++;
            } else {
                break;
            }
        }

        if (head >= symbols.size()) {
            head = 0;
        }
    }

    public Tape(Tape tape) {
        this.symbols = new ArrayList<>(tape.getSymbols());
        this.head = tape.getHead();
    }

    public List<Character> getSymbols() {
        return symbols;
    }

    public int getHead() {
        return head;
    }

    public void moveHead(OPERATION operation) {
        switch (operation) {
            case R:
                this.head++;
                if (this.head > this.symbols.size() - 1) {
                    this.head = this.symbols.size();
                    this.symbols.add('#');
                }
                break;
            case L:
                this.head--;
                if (this.head < 0) {
                    this.head = 0;
                    this.symbols.add(0,'#');
                }
                break;
            case S:
                break;
        }
    }
}
