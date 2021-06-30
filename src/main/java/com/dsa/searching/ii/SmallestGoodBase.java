package com.dsa.searching.ii;

public class SmallestGoodBase {
    public String solve(String A) {

        //An = a*(r^(n-1))
        //G.P = a((r^n)-1)/(r-1)
        //here if base is b then num = 1 + b + b^2 + .... b^(m-1) where m is bit position
        //num = (b^m - 1)/(b-1)
        long num = Long.parseLong(A);

        //as 3 <= A <= 10^18 , 3 will have 2 bits in base 2
        //check for every bit position from 2 to 61, i.e from (11)base X to (11....11) base X
        //do binary search on possible values of X, i.e from 2 to num-1
        for (int i = 60; i >= 2; i--) {
            long l = 2L;
            long r = num - 1L;
            while (l <= r) {
                long baseMid = l + ((r - l) / 2L);
                int possible = isPossible(baseMid, i, num);

                if (possible > 0) {//reduce base
                    r = baseMid - 1L;
                } else if (possible < 0) {//increase base
                    l = baseMid + 1L;
                } else {
                    return baseMid + "";
                }
            }
        }
        return (num - 1L) + ""; // for N, N-1 will always be a good base
    }

    //if its possible to achieve num with digits no. of set bits with base
    //return 1 if sum > num
    //return 0 if sum = num
    //return -1 if sum < num
    private int isPossible(long base, int digits, long num) {
        if (base >= num)
            return 1;

        long mul = 1;
        for (int i = 0; (i <= digits && num >= 0); i++) {
            num -= mul;
            if (i != digits) {
                if (mul > num / base)
                    return 1;
            }
            mul = mul * base;
        }
        if (num == 0) {
            return 0;
        }
        if (num > 0) {
            return -1;
        }
        return 1;
    }
}
/*
Smallest Good Base
Given an integer A, we call k >= 2 a good base of A, if all digits of A base k are 1. Now given a string representing A, you should return the smallest good base of A in string format.


Input Format

The only argument given is the string representing A.
Output Format

Return the smallest good base of A in string format.
Constraints

3 <= A <= 10^18
For Example

Input 1:
    A = "13"
Output 1:
    "3"     (13 in base 3 is 111)

Input 2:
    A = "4681"
Output 2:
    "8"     (4681 in base 8 is 11111).


 */