package com.dsa.greedy.i;

import java.util.ArrayList;
import java.util.Arrays;

public class TheShipCompany {

    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {

        //can be done using minHeap, maxHeap also
        int currentShipIndex = 0;
        ArrayList<Integer> copyC = new ArrayList<>(C);

        int min = 0;
        //minimum case, go to next ship if current ship is full
        for (int i = 1; i <= A; i++) {
            currentShipIndex = getShipWithMinCost(copyC);
            min += copyC.get(currentShipIndex);
            copyC.set(currentShipIndex, copyC.get(currentShipIndex) - 1);
        }

        copyC = new ArrayList<>(C);

        int max = 0;
        //maximum case, fill each ship simultaneously as much as possible
        for (int i = 1; i <= A; i++) {
            currentShipIndex = getShipWithMaxCost(copyC);
            max += copyC.get(currentShipIndex);
            copyC.set(currentShipIndex, copyC.get(currentShipIndex) - 1);
        }
        return new ArrayList<>(Arrays.asList(max, min));
    }

    //returns ship index having least seats vacant
    private int getShipWithMinCost(ArrayList<Integer> C) {

        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < C.size(); i++) {
            if (C.get(i) > 0 && C.get(i) < min) {
                min = C.get(i);
                index = i;
            }
        }
        return index;
    }

    //returns ship index having max seats vacant
    private int getShipWithMaxCost(ArrayList<Integer> C) {

        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < C.size(); i++) {
            if (C.get(i) > 0 && C.get(i) > max) {
                max = C.get(i);
                index = i;
            }
        }
        return index;
    }
}
/*
The ship company
Problem Description

The local ship renting service has a special rate plan:

It is up to a passenger to choose a ship.
If the chosen ship has X (X > 0) vacant places at the given moment, then the ticket for such a ship costs X.
The passengers buy tickets in turn, the first person in the queue goes first, then goes the second one, and so on up to A-th person.

You need to tell the maximum and the minimum money that the ship company can earn if all A passengers buy tickets.



Problem Constraints
1 ≤ A ≤ 3000
1 ≤ B ≤ 1000
1 ≤ C[i] ≤ 1000
It is guaranteed that there are at least A empty seats in total.



Input Format
First argument is a integer A denoting the number of passengers in the queue.
Second argument is a integer B denoting the number of ships.
Third argument is an integer array C of size B where C[i] denotes the number of empty seats in the i-th ship before the ticket office starts selling tickets.



Output Format
Return an array of size 2 denoting the maximum and minimum money that the ship company can earn.



Example Input
Input 1:

 A = 4
 B = 3
 C = [2, 1, 1]
Input 2:

 A = 4
 B = 3
 C = [2, 2, 2]


Example Output
Output 1:

 [5, 5]
Output 2:

[7, 6]


Example Explanation
Explanation 1:

 Maximum money can be earned if the passenger choose : 2(first ship) + 1(first ship) + 1(second ship) + 1(third ship).
 So, the cost will be 5.
 Minimum money can be earned if the passenger choose : 1(second ship) + 2(first ship) + 1(first ship) + 1(third ship).
 So, the cost will be 5.
Explanation 2:

 Maximum money can be earned if the passenger choose : 2(first ship) + 2(second ship) + 2(third ship) + 1(first ship).
 So, the cost will be 7.
 Minimum money can be earned if the passenger choose : 2(second ship) + 2(first ship) + 1(first ship) + 1(second ship).
 So, the cost will be 6.

 */
