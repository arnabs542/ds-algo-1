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
/*
Sort Array in given Order
Problem Description

Given two array of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B. For the elements not present in B, append them at last in sorted order.

Return the array A after sorting from the above method.

NOTE: Elements of B are unique.



Problem Constraints
1 <= length of the array A <= 100000

1 <= length of the array B <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is the integer array B.



Output Format
Return the array A after sorting as described.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = [5, 4, 2]
Input 2:

A = [5, 17, 100, 11]
B = [1, 100]


Example Output
Output 1:

[5, 4, 2, 1, 3]
Output 2:

[100, 5, 11, 17]


Example Explanation
Explanation 1:

 Simply sort as described.
Explanation 2:

 Simply sort as described.

 */
