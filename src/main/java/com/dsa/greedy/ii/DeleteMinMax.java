package com.dsa.greedy.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeleteMinMax {

    public int solve(ArrayList<Integer> A) {

        HashMap<Integer, Integer> map = new HashMap<>(); //to store # of occurrences of each number

        //idea is to pick 3 numbers that are same as much as possible
        for (int i = 0; i < A.size(); i++) {
            Integer count = map.getOrDefault(A.get(i), 0);

            if (count == 2) { //already have 2, means with new one can club as 3 together, resultant will be 1
                count = 1;
            } else {
                count++;
            }
            map.put(A.get(i), count);
        }

        int ones = 0; //no. of numbers with occurrence count as 1
        int twos = 0; //no. of numbers with occurrence count as 2
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 2) {
                twos++;
            } else {
                ones++;
            }
        }
        //ones will always be there in ans, twos if odd contribute one lesser (as it needs to be clubbed with one of the ones)
        return ones + (twos % 2 == 1 ? twos - 1 : twos);
    }
}
