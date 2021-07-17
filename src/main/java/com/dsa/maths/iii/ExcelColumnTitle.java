package com.dsa.maths.iii;

public class ExcelColumnTitle {

    public String convertToTitle(int n) {

        /*
        For a title "LEET":
            L = 12
            E = (12 x 26) + 5 = 317
            E = (317 x 26) + 5 = 8247
            T = (8247 x 26) + 20 = 214442
         */
        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            int rem = n % 26; // rem will be btn 0->25, where 0->Z, 1->A, 2->B, .... 25->Y
            rem = (rem == 0) ? 26 : rem;
            ans.append((char) (rem + 'A' - 1));
            n = (n - rem) / 26; //subtract rem from n, as we need to remove contribution of current char in n
        }
        return ans.reverse().toString();
    }
}
/*
Excel Column Title
Problem Description

Given a positive integer A, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB


Problem Constraints
1 <= A <= 109



Input Format
First and only argument of input contains single integer A



Output Format
Return a string denoting the corresponding title.



Example Input
Input 1:

A = 3
Input 2:


A = 27


Example Output
Output 1:

"C"
Output 2:

"AA"


Example Explanation
Explanation 1:


3 corrseponds to C.
Explanation 2:

    1 -> A,
    2 -> B,
    3 -> C,
    ...
    26 -> Z,
    27 -> AA,
    28 -> AB

 */