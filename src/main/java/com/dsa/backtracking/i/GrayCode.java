package com.dsa.backtracking.i;

import java.util.ArrayList;

public class GrayCode {

    public ArrayList<Integer> grayCode(int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        recurse(ans, N);
        return ans;
    }

    private void recurse(ArrayList<Integer> arr, int N) {
        if (N == 1) { //add 0 and 1 in order
            arr.add(0);
            arr.add(1);
            return;
        }
        recurse(arr, N - 1);
        for (int i = arr.size() - 1; i >= 0; i--) {//eg: for N==2 take each no. of N=1 case from backwards and add to it 10 (i.e 1 << (2-1) )
            arr.add(arr.get(i) + (1 << (N - 1)));
        }
    }
}
