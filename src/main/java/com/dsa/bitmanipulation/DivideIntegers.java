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
