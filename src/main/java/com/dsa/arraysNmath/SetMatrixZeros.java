package com.dsa.arraysNmath;

import java.util.ArrayList;

public class SetMatrixZeros {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        int rows = a.size();
        int columns = a.get(0).size();

        // identify if first row and first column has to be 0
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        for (int i = 0; i < columns; i++) {
            if (a.get(0).get(i) == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            if (a.get(i).get(0) == 0) {
                firstColumnZero = true;
                break;
            }
        }

        //make use of first row and first column as extra space to store
        //if an element is 0 from 1,1 then make the first row and first column corresponding to that element as 0
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(0).set(j, 0);
                    a.get(i).set(0, 0);
                }
            }
        }

        //now iterate all elements from 1,1 and check if corresponding first row or first column is 0, then make the element 0
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (a.get(0).get(j) == 0 || a.get(i).get(0) == 0) {
                    a.get(i).set(j, 0);
                }
            }
        }

        // now check if first row has to be zero, if yes make all 0
        if (firstRowZero) {
            for (int i = 0; i < columns; i++) {
                a.get(0).set(i, 0);
            }
        }
        // now check if first column has to be zero, if yes make all 0
        if (firstColumnZero) {
            for (int i = 0; i < rows; i++) {
                a.get(i).set(0, 0);
            }
        }
    }
}


