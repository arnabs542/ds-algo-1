package com.dsa.heaps.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BthSmallestPrimeFraction {

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        ArrayList<Pair<Integer, Integer>> fractions = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) < A.get(j)) {
                    fractions.add(new Pair<>(A.get(i), A.get(j)));
                }
            }
        }

        Comparator<Pair<Integer, Integer>> customComparator = (a, b) -> {
            Double fracA = ((double) a.num) / a.denom;
            Double fracB = ((double) b.num) / b.denom;
            return fracA.compareTo(fracB);
        };

        Collections.sort(fractions, customComparator);
        return new ArrayList<>(Arrays.asList(fractions.get(B - 1).num, fractions.get(B - 1).denom));
    }

    static class Pair<T, U> {
        T num;
        U denom;

        Pair(T t, U u) {
            this.num = t;
            this.denom = u;
        }
    }
}
/*
B-th Smallest Prime Fraction
Problem Description

A sorted array of integers, A contains 1, plus some number of primes. Then, for every p < q in the list, we consider the fraction p/q.

What is the B-th smallest fraction considered?

Return your answer as an array of integers, where answer[0] = p and answer[1] = q.



Problem Constraints
1 <= length(A) <= 2000
1 <= A[i] <= 30000
1 <= B <= length(A)*(length(A) - 1)/2



Input Format
The first argument of input contains the integer array, A.
The second argument of input contains an integer B.



Output Format
Return an array of two integers, where answer[0] = p and answer[1] = q.



Example Input
Input 1:

 A = [1, 2, 3, 5]
 B = 3
Input 2:

 A = [1, 7]
 B = 1


Example Output
Output 1:

 [2, 5]
Output 2:

 [1, 7]


Example Explanation
Explanation 1:

 The fractions to be considered in sorted order are:
 [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
 The third fraction is 2/5.
Explanation 2:

 The fractions to be considered in sorted order are:
 [1/7]
 The first fraction is 1/7.

 */
