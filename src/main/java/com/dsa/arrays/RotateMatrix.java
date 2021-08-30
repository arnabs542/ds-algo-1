package com.dsa.arrays;

import java.util.ArrayList;

public class RotateMatrix {
    public void solve(ArrayList<ArrayList<Integer>> a) {

        //this problem can also be solved by taking transpose of the matrix and reversing elements in all rows

        int N = a.size();
        //only N/2 iterations needed. For eg: for 4x4 matrix we take outer elements and another set of inner matrix's outer elements
        for (int i = 0; i < N / 2; i++) {

            //need to swap (j)*4 elements everytime
            //each of the 4 elements to be swapped are being swapped below
            for (int j = i; j < N - i - 1; j++) {

                Integer temp = a.get(i).get(j);

                //observation needed here to get the below formula
                a.get(i).set(j, a.get(N - j - 1).get(i));
                a.get(N - j - 1).set(i, a.get(N - i - 1).get(N - j - 1));
                a.get(N - i - 1).set(N - j - 1, a.get(j).get(N - i - 1));
                a.get(j).set(N - i - 1, temp);
            }
        }
    }
}
