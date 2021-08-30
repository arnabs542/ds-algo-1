package com.dsa.arrays;

public class MinimumJumps {

    public int solve(int[] A) {

        int end = 0;
        int jumps = 0;
        int farthest = 0;

        for (int i = 0; i < A.length - 1; i++) {
            farthest = Math.max(farthest, i + A[i]); // max jump possible at index i

            if (i > end) {// not possible to reach last
                return -1;
            }

            if (i == end) {// need to jump
                jumps++;
                end = farthest;// update where farthest jump will take you
            }
        }
        return jumps;

        // if (A[0] == 0 || A.length <= 1)
        //     return -1;

        // int ladder = A[0];
        // int stairs = ladder - 0; //stairs = ladder - i

        // int jumps = 0;
        // for (int i = 1; i < A.length; i++) {

        //     //store the max length ladder available till that time, discard smaller ladders
        //     //smaller ladder implies smaller jump
        //     //we added i to A[i] because from i we can jump to i+A[i] position, so ladder length is also i+A[i]
        //     ladder = Math.max(ladder, i + A[i]);

        //     if (i == A.length - 1) {
        //         return jumps + 1;// adding 1 for the final landing jump
        //     }
        //     //decrement stairs as we traverse the array
        //     stairs--;

        //     //when no more stairs to climb, we need to make a jump
        //     //now we jump to next available max ladder with no. of stairs = ladder - i
        //     if (stairs == 0) {
        //         jumps++;
        //         stairs = ladder - i;
        //     }
        // }

        // return -1;

        // if (A[0] == 0 || A.length <= 1){
        //     return -1;
        // }


    }
}
