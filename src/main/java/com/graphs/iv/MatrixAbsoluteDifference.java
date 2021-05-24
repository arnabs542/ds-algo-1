package com.graphs.iv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MatrixAbsoluteDifference {

    private int[] parent;
    private int[] size;

    public int solve(int A, int B, int[][] C) {

        parent = new int[A * B];
        size = new int[A * B];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] rows = new int[]{-1, 0, 0, 1};
        int[] cols = new int[]{0, 1, -1, 0};

        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {

                for (int k = 0; k < rows.length; k++) {

                    int nextI = i + rows[k];
                    int nextJ = j + cols[k];

                    if (!(nextI < 0 || nextI >= C.length || nextJ < 0 || nextJ >= C[0].length)) {
                        int weight = Math.abs(C[i][j] - C[nextI][nextJ]);

                        List<Pair> pairs = map.getOrDefault(weight, new ArrayList<>());
                        pairs.add(new Pair(B * nextI + nextJ, B * i + j)); //add both cells with absolute value

                        map.put(weight, pairs);
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
            List<Pair> pairs = entry.getValue();

            for (Pair p : pairs) {
                int p1 = findParent(p.node1);
                int p2 = findParent(p.node2);

                if (p1 != p2) {
                    union(p.node1, p.node2);
                    //get i,j indices from absolute value
                    int node1I = p.node1 / B;
                    int node1J = p.node1 % B;
                    int node2I = p.node2 / B;
                    int node2J = p.node2 % B;
                    ans = Math.max(ans, Math.abs(C[node1I][node1J] - C[node2I][node2J]));
                }
            }
        }
        return ans;
    }

    private int findParent(int node) {

        while (node != parent[node]) {
            node = parent[node];
        }
        return node;
    }

    private boolean union(int node1, int node2) {

        int p1 = findParent(node1);
        int p2 = findParent(node2);

        if (p1 != p2) {
            if (size[p1] < size[p2]) {
                parent[p1] = p2;
                size[p2] += size[p1];
            } else {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
            return true;
        }
        return false;
    }

    static class Pair {
        int node1;
        int node2;

        Pair(int i, int j) {
            this.node1 = i;
            this.node2 = j;
        }
    }
}

/*

Matrix and Absolute Difference
Problem Description

Given a matrix C of integers, of dimension A x B.

For any given K, you are not allowed to travel between cells that have an absolute difference greater than K.

Return the minimum value of K such that it is possible to travel between any pair of cells in the grid through a path of adjacent cells.

NOTE:

Adjacent cells are those cells that share a side with the current cell.


Problem Constraints
1 <= A, B <= 102

1 <= C[i][j] <= 109



Input Format
The first argument given is A.

The second argument give is B.

The third argument given is the integer matrix C.



Output Format
Return a single integer, the minimum value of K.



Example Input
Input 1:

 A = 3
 B = 3
 C = [  [1, 5, 6]
        [10, 7, 2]
        [3, 6, 9]   ]


Example Output
Output 1:

 4


Example Explanation
Explanation 1:


 It is possible to travel between any pair of cells through a path of adjacent cells that do not have an absolute
 difference in value greater than 4. e.g. : A path from (0, 0) to (2, 2) may look like this:
 => (0, 0) -> (0, 1) -> (1, 1) -> (2, 1) -> (2, 2)
 */