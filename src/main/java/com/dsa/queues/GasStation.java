package com.dsa.queues;

public class GasStation {
    public int canCompleteCircuit(final int[] gas, final int[] cost) {

        if (gas.length == 1)
            return 0;

        int power = 0; //total power that remains
        int startIdx = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            power += gas[i] - cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) { //no fuel left to move further, so reset startIdx and tank
                startIdx = i + 1;
                tank = 0;
            }
        }
        if (power <= 0) { //no power left, so not possible
            return -1;
        } else {
            return startIdx;
        }
    }
}
/*
Gas Station
Given two integer arrays gas and cost of size N. There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.

You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2.. Completing the circuit means starting at i and ending up at i again.


Input Format

The first argument given is the integer array gas.
The second argument given is the integer array cost.
Output Format

Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
For Example

Input 1:
    gas =  [1, 2]
    cost =  [2, 1]
Output 1:
    1
    Explanation 1:
        If you start from index 0, you can fill in gas[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need cost[0] = 2 gas to travel to station 1.
        If you start from index 1, you can fill in gas[1] = 2 amount of gas. Now your tank has 2 units of gas. You need cost[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over. You fill in gas[0] = 1 unit of additional gas, making your current gas = 2. It costs you cost[0] = 2 to get to station 1, which you do and complete the circuit.


 */