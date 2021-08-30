package com.dsa.graphs.ii;

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

