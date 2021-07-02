package com.dsa.arrays;

public class AddOneToNumber {
    public int[] plusOne(int[] A) {

        int carry = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int sum = A[i] + carry;
            carry = (sum > 9) ? 1 : 0;
            A[i] = sum % 10;
        }

        //if carry is 1, create new array  with one more element
        if (carry == 1) {
            int[] newArray = new int[A.length + 1];
            newArray[0] = carry;

            //copy remaining elements
            for (int i = 0; i < A.length; i++) {
                newArray[i + 1] = A[i];
            }
            return newArray;
        } else {
            //count leading zeroes
            int countLeadingZeroes = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == 0) {
                    countLeadingZeroes++;
                } else {
                    break;
                }
            }

            //array length excluding leading zeroes
            int[] newArray = new int[A.length - countLeadingZeroes];

            //copy remaining elements
            for (int i = countLeadingZeroes; i < A.length; i++) {
                newArray[i - countLeadingZeroes] = A[i];
            }
            return newArray;
        }
    }
}
/*
Add One To Number
Problem Description

Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :

Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= size of the array <= 1000000



Input Format
First argument is an array of digits.



Output Format
Return the array of digits after adding one.



Example Input
Input 1:

[1, 2, 3]


Example Output
Output 1:

[1, 2, 4]


Example Explanation
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.

 */