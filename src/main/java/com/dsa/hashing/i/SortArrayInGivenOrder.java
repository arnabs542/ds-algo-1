package com.dsa.hashing.i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SortArrayInGivenOrder {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            map.put(B.get(i), i); //insert into the map in the order of occurrence in B
        }

        Comparator<Integer> customSort = (Integer i1, Integer i2) -> {
            if (map.get(i1) == null && map.get(i2) == null) {
                return i1.compareTo(i2); //when order not defined in array B, sort on natural order
            } else if (map.get(i1) == null) {
                return 1;
            } else if (map.get(i2) == null) {
                return -1;
            } else {
                return map.get(i1).compareTo(map.get(i2)); //sort based on the order defined in the array B (which is defined in the map)
            }
        };
        Collections.sort(A, customSort);
        return A;
    }
}

