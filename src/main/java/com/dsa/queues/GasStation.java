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
