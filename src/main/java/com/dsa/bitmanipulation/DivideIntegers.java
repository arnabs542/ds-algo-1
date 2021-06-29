package com.dsa.bitmanipulation;

public class DivideIntegers {

    public int divide(int A, int B) {

        //corner case, only case where overflow happens
        if ((Integer.MIN_VALUE == A) && (B == -1)) {
            return Integer.MAX_VALUE;
        }

        int a = Math.abs(A); //if A = Integer.MIN_VALUE, Math.abs(A) = Integer.MIN_VALUE only, sign won't change
        int b = Math.abs(B);
        int res = 0;

        // Integer.MIN_VALUE = -2147483648
        // A = -2147483648, B = 2
        // A-B = -2147483648 - 2 = 2147483646 (as -2147483650 doesn't fit into int it is wrapped)
        // Significance of putting a-b >=0
        while (a - b >= 0) {// need to write (a-b >= 0) and not (a >= b)
            int x = 0;
            // 43/8 -> 43 - (8) -> 43 - (8*2*2) -> 43 - (8*2*2*2*2) stops here as  43 - (8*2*2*2*2) is -ve
            //repeated subtraction but bit manipulation allows only multiplcation by 2
            while ((a - ( b << x << 1)) >= 0) { // x << 1 = x*2
                x++;
            }
            a -= b << x; //43 - (8 << 2)  = 11
            res += 1 << x; //1 * 2^2 = 4
        }
        return (A > 0) == (B > 0) ? res : -res; // reverse sign if either of them is negative
    }
}
/*
Divide Integers
Problem Description

Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.

NOTE: INT_MAX = 2^31 - 1



Problem Constraints
-231 <= A, B <= 231-1

B!= 0



Input Format
First argument is an integer A denoting the dividend.
Second argument is an integer B denoting the divisor.



Output Format
Return an integer denoting the floor value of the division.



Example Input
Input 1:

 A = 5
 B = 2
Input 2:

 A = 7
 B = 1


Example Output
Output 1:

 2
Output 2:

 7


Example Explanation
Explanation 1:

 floor(5/2) = 2

 */