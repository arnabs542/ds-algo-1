package com.dsa.maths.iii;

public class ExcelColumnNumber {

    public int titleToNumber(String A) {
        /*
        For a title "LEET":
            L = 12
            E = (12 x 26) + 5 = 317
            E = (317 x 26) + 5 = 8247
            T = (8247 x 26) + 20 = 214442
         */

        int result = 0;

        for (int i = 0; i < A.length(); i++) {
            result *= 26;
            result += A.charAt(i) - 'A' + 1;
        }
        return result;

        // A,B,C,D... correspond to 1,2,3,4
        // BA = 1*(26^0) + 2*(26^1)
//        int sum = 0;
//        for (int i = A.length() - 1; i >= 0; i--) {
//            int a = A.charAt(i) - 'A' + 1;
//            sum += a * Math.pow(26, A.length() - 1 - i);
//        }
//        return sum;
    }
}
/*
Excel Column Number
Problem Description

Given a column title as appears in an Excel sheet, return its corresponding column number.



Problem Constraints
1 <= length of the column title <= 5



Input Format
Input a string which represents the column title in excel sheet.



Output Format
Return a single integer which represents the corresponding column number.



Example Input
Input 1:

 AB
Input 2:

 ABCD


Example Output
Output 1:

 28
Output 2:

 19010


Example Explanation
Explanation 1:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28

 */