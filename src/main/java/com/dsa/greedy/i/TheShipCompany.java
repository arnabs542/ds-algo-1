package com.dsa.greedy.i;

import java.util.ArrayList;
import java.util.Arrays;

public class TheShipCompany {

    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {

        //can be done using minHeap, maxHeap also
        int currentShipIndex = 0;
        ArrayList<Integer> copyC = new ArrayList<>(C);

        int min = 0;
        //minimum case, go to next ship if current ship is full
        for (int i = 1; i <= A; i++) {
            currentShipIndex = getShipWithMinCost(copyC);
            min += copyC.get(currentShipIndex);
            copyC.set(currentShipIndex, copyC.get(currentShipIndex) - 1);
        }

        copyC = new ArrayList<>(C);

        int max = 0;
        //maximum case, fill each ship simultaneously as much as possible
        for (int i = 1; i <= A; i++) {
            currentShipIndex = getShipWithMaxCost(copyC);
            max += copyC.get(currentShipIndex);
            copyC.set(currentShipIndex, copyC.get(currentShipIndex) - 1);
        }
        return new ArrayList<>(Arrays.asList(max, min));
    }

    //returns ship index having least seats vacant
    private int getShipWithMinCost(ArrayList<Integer> C) {

        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < C.size(); i++) {
            if (C.get(i) > 0 && C.get(i) < min) {
                min = C.get(i);
                index = i;
            }
        }
        return index;
    }

    //returns ship index having max seats vacant
    private int getShipWithMaxCost(ArrayList<Integer> C) {

        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < C.size(); i++) {
            if (C.get(i) > 0 && C.get(i) > max) {
                max = C.get(i);
                index = i;
            }
        }
        return index;
    }
}

