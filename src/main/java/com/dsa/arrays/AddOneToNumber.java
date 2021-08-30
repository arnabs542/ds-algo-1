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
