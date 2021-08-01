package com.dsa.backtracking.ii;

import java.util.HashMap;

//leet code implementation
public class MinimumSwapsToArrangePairs {

    public int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }

        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int partner = row[i] ^ 1;
            if (row[i + 1] == partner)
                continue;

            ans++;
            int partnerIndex = map.getOrDefault(partner, -1);

            //update map indices and swap
            map.put(partner, i + 1);
            map.put(row[i + 1], partnerIndex);
            swap(row, i + 1, partnerIndex);
        }
        return ans;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
/*
Minimum Swaps To Arrange Pairs
Problem Description

There are A pairs and therefore 2A people. Each person has a unique number ranging from 1 to 2A. An array of integers B shows the arrangement of these 2A people.

A matrix C of size A x 2 is given describing pairs i.e. people that are partner of each other. C[i][0] and C[i][1] are partner of each other.

Find the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.



Problem Constraints
1 <= A <= 20

1 <= B[i] <= 2*A

C[i][0]!=C[i][1]

1 <= C[i][0], C[i][1] <= 2*A



Input Format
The First argument given is an integer A.

The Second argument given is the integer array B.

The Third argument given is matrix C.



Output Format
Return the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.



Example Input
Input 1:

A = 3
B = [3, 5, 6, 4, 1, 2]
C = [   [1, 3]
        [2, 6]
        [4, 5]  ]
Input 2:

A = 1
B = [1, 2]
C = [ [1, 2] ]


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

One of the ways to arraange them
1. swap(5 and 6) order becomes : [3, 6, 5, 4, 1, 2]
2. swap(6 and 1) order becomes:  [3, 1, 5, 4, 6, 2]
Explanation 2:

No swaps required.

 */
