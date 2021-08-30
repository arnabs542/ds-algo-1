package com.dsa.greedy.i;

import java.util.ArrayList;

public class Seats {
    public int seats(String A) {

        int mod = 10000003;

        ArrayList<Integer> occupied = new ArrayList<>(); //occupied positions
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                occupied.add(i);
            }
        }
        int medianIdx = occupied.size() / 2; //idea is to move everyone closer to median

        //example occupied array = [4,6,9,12] , 9 is median
        //after moving it should be [7,8,9,10]
        //ans = |4-7| + |6-8| + |9-9| + |12-10|
        int total = 0;
        for (int i = 0; i < occupied.size(); i++) {
            int newPosition = occupied.get(medianIdx) - medianIdx + i; //new position of person at occupied[i]
            total = (total + Math.abs(newPosition - occupied.get(i)) % mod) % mod;
        }
        return total;
    }
}
