package com.dsa.greedy.i;

public class BulbsNSwitches {

    public int bulbs(int[] A) {

        int flag = 0; //no. of toggles
        //so we need to toggle a switch when it is in the off state
        //off state -> when it is originally 0 and flags is even
        //off state -> when it is originally 1 and flag is odd
        for (int i = 0; i < A.length; i++) {
            if ((A[i] == 0 && flag % 2 == 0) || (A[i] == 1 && flag % 2 == 1)) {
                flag++;
            }
        }
        return flag;
    }
}
