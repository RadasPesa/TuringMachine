package com.company;

import com.company.model.Tape;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        TuringMachine tm = TMLibrary.getLibrary1();

        boolean output = tm.run(new Tape("###xyxyxxxy###"), true);
        */

        /*
        TuringMachine tm = TMLibrary.getLibrary2();

        Tape t1 = new Tape("###acbabca###");
        Tape t2 = new Tape("#############");
        List<Tape> inputTapes = new ArrayList<>();
        inputTapes.add(t1);
        inputTapes.add(t2);
        boolean output = tm.run(inputTapes, true);
        */

        /*
        TuringMachine tm = TMLibrary.getSuccessorLibrary();

        boolean output = tm.run(new Tape("###1111###"), false);
        */

        /*
        TuringMachine tm = TMLibrary.getPredecessorLibrary();

        boolean output = tm.run(new Tape("###10###"), false);
        */

        /*
        TuringMachine tm = TMLibrary.getProjectorLibrary();

        // Project nth number from m numbers
        // Form of input: #n#m#1st#2nd#...#nth#
        Tape t1 = new Tape("10#11#10#1#101##"); // input
        Tape t2 = new Tape("################"); // iterator
        Tape t3 = new Tape("################"); // output
        List<Tape> inputTapes = List.of(t1, t2, t3);
        boolean output = tm.run(inputTapes, false);
        */


        TuringMachine tm = TMLibrary.getAdditionLibrary();

        boolean output = tm.run(new Tape("###101#11###"), false);


        /*
        TuringMachine tm = TMLibrary.getNullLibrary();

        boolean output = tm.run(new Tape("#101#"), false);
        */
    }
}
