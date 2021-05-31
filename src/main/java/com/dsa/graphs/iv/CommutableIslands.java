package com.dsa.graphs.iv;

import java.util.Arrays;
import java.util.Comparator;

public class CommutableIslands {

    private int[] parent;
    private int[] size;

    // Minimum spanning tree
    // refer class notes for explanation
    public int solve(int A, int[][] B) {

        parent = new int[A + 1];
        size = new int[A + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Comparator<int[]> customComparator = (a, b) -> {
            return Integer.valueOf(a[2]).compareTo(Integer.valueOf(b[2]));
        };
        Arrays.sort(B, customComparator);

        int ans = 0;
        for (int i = 0; i < B.length; i++) {
            if (unionEdge(B[i][0], B[i][1])) {
                ans += B[i][2];
            }
        }
        return ans;
    }

    private int findParent(int node) {

        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    private boolean unionEdge(int node1, int node2) {

        int p1 = findParent(node1);
        int p2 = findParent(node2);

        if (p1 != p2) {
            if (size[p1] < size[p2]) {
                size[p2] += size[p1];
                parent[p1] = p2;
            } else {
                size[p1] += size[p2];
                parent[p2] = p1;
            }
            return true;
        }
        return false;
    }
}

/*
Commutable Islands
Problem Description

There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints
1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103



Input Format
The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format
Return an integer representing the minimal cost required.



Example Input
Input 1:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]
Input 2:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]


Example Output
Output 1:

 6
Output 2:

 6


Example Explanation
Explanation 1:

 We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
Explanation 2:

 We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.

 */
