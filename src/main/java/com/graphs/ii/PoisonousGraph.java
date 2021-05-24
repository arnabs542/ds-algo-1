package com.graphs.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class PoisonousGraph {

    private boolean[] visited;
    private int[] color;
    private long ans;
    private int mod = 998244353;
    private HashMap<Integer, ArrayList<Integer>> adjMap;

    public int solve(int A, int[][] B) {

        visited = new boolean[A + 1];
        color = new int[A + 1];
        Arrays.fill(color, -1);

        ans = 1L;
        adjMap = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            ArrayList<Integer> val = adjMap.getOrDefault(B[i][0], new ArrayList<>());
            val.add(B[i][1]);

            adjMap.put(B[i][0], val);

            val = adjMap.getOrDefault(B[i][1], new ArrayList<>());
            val.add(B[i][0]);

            adjMap.put(B[i][1], val);
        }

        if (B.length == 0) {
            return (int) power(3, A, mod);
        }

        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                int[] component = iterativeDfsForColoring(i); //should be bipartited and should return x,y values;

                if (component[0] == -1 && component[1] == -1) { //bipartite not possible
                    return 0;
                }
                long currAns = (power(2, component[0], mod) + power(2, component[1], mod)) % mod;
                ans = multiply(ans, currAns);
            }
        }
        return (int) ans % mod;
    }

    //returns array of 2 integers that denote nodes with color0 and color1 respectively.
    private int[] iterativeDfsForColoring(int node) {

        int x = 0;
        int y = 0;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(node, 0));

        while (!stack.empty()) {

            Pair pair = stack.pop();
            if (!visited[pair.node]) {
                if (pair.color == 0) {
                    x++;
                } else {
                    y++;
                }
                visited[pair.node] = true;
                color[pair.node] = pair.color;

                for (Integer n : adjMap.getOrDefault(pair.node, new ArrayList<>())) {

                    if (color[n] == -1 && !visited[n]) { //dfs on neighbour with opposite color
                        stack.push(new Pair(n, 1 - pair.color));
                    }
                    if (color[n] == pair.color) { //if neighbour colored with same color, can't be bipartite
                        return new int[]{-1, -1};
                    }
                }
            }
        }
        return new int[]{x, y};
    }

    //returns (a*b)%mod in log(b) time
    private long multiply(long a, long b) {

        long res = 0;
        a = a % mod;
        while (b > 0) {
            if (b % 2 == 1) {
                res = (res + a) % mod;
            }
            a = (a * 2) % mod;
            b /= 2;
        }
        return res % mod;
    }

    private long power(long a, long b, long p) {

        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return 0L;
        } else if (b % 2 == 0) {
            return power(((a % p) * (a % p)) % p, b / 2, p) % p;
        } else {
            return ((a % p) * (power((a * a) % p, (b - 1) / 2, p) % p)) % p;
        }
    }

    static class Pair {
        int node;
        int color;

        Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }
}

/*
Poisonous Graph
Problem Description

You are given an undirected unweighted graph consisting of A vertices and M edges given in a form of 2D Matrix B of size M x 2 where (B[i][0], B][i][1]) denotes two nodes connected by an edge.

You have to write a number on each vertex of the graph. Each number should be 1, 2 or 3. The graph becomes Poisonous if for each edge the sum of numbers on vertices connected by this edge is odd.

Calculate the number of possible ways to write numbers 1, 2 or 3 on vertices so the graph becomes poisonous. Since this number may be large, return it modulo 998244353.

NOTE:

Note that you have to write exactly one number on each vertex.
The graph does not have any self-loops or multiple edges.
Nodes are labelled from 1 to A.


Problem Constraints
1 <= A <= 3*105

0 <= M <= 3*105

1 <= B[i][0], B[i][1] <= A

B[i][0] != B[i][1]



Input Format
First argument is an integer A denoting the number of nodes.

Second argument is an 2D Matrix B of size M x 2 denoting the M edges.



Output Format
Return one integer denoting the number of possible ways to write numbers 1, 2 or 3 on the vertices of given graph so it becomes Poisonous . Since answer may be large, print it modulo 998244353.



Example Input
Input 1:

 A = 2
 B = [  [1, 2]
     ]
Input 2:

 A = 4
 B = [  [1, 2]
        [1, 3]
        [1, 4]
        [2, 3]
        [2, 4]
        [3, 4]
    ]


Example Output
Output 1:

 4
Output 2:

 0


Example Explanation
Explanation 1:

 There are 4 ways to make the graph poisonous. i.e, writing number on node 1 and 2 as,
    [1, 2] , [3, 2], [2, 1] or [2, 3] repsectively.
Explanation 2:

 There is no way to make the graph poisonous.
 */