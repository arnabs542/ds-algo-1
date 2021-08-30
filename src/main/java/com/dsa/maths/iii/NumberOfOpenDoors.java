package com.dsa.maths.iii;

public class NumberOfOpenDoors {

    public int solve(int A) {
        //if a door # has odd no. of factors, it will be open
        //only perfect squares have odd no. of factors
        //no. of perfect squares till N = sqrt(N)
        return (int) Math.sqrt(A);
    }
}
