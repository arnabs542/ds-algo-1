package com.dsa.sorting.ii;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {

        Comparator<Integer> customComparator = (s1, s2) -> {
            String a = Integer.toString(s1);
            String b = Integer.toString(s2);
            return (b + a).compareTo(a + b);//custom sort to check if ab > ba
        };
        Collections.sort(A, customComparator);

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < A.size(); i++) {
            if (!(A.get(i) == 0 && ans.length() == 0)) {//to avoid leading zeroes
                ans.append(A.get(i));
            }
        }

        if (ans.length() == 0) {//occurs when all elements are 0's
            ans.append("0");
        }
        return ans.toString();
    }
}
/*
Largest Number
Problem Description

Given a array A of non negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
First argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

 A = [3, 30, 34, 5, 9]
 Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

 Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

 */
