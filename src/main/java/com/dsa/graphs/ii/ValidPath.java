package com.dsa.graphs.ii;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidPath {

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {

        int[] rows = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
        int[] cols = new int[]{-1, 1, 0, 1, -1, 0, -1, 1};

        boolean[][] visited = new boolean[A + 1][B + 1];

        if (inCircle(0, 0, C, D, E, F)) {
            return "NO";
        }

        //queue for doing BFS
        Deque<Pair> deque = new ArrayDeque<>();
        deque.addLast(new Pair(0, 0));
        visited[0][0] = true;

        while (!deque.isEmpty()) {

            Pair pair = deque.pollFirst();

            if (pair.i == A && pair.j == B) {
                return "YES";
            }

            for (int k = 0; k < rows.length; k++) {

                int nexti = pair.i + rows[k];
                int nextj = pair.j + cols[k];

                if (nexti >= 0 && nexti < (A + 1) && nextj >= 0 && nextj < (B + 1)
                        && !visited[nexti][nextj] && !inCircle(nexti, nextj, C, D, E, F)) {
                    visited[nexti][nextj] = true;
                    deque.addLast(new Pair(nexti, nextj));
                }
            }
        }
        return "NO";
    }

    private boolean inCircle(int x, int y, int C, int D, int[] E, int[] F) {
        for (int i = 0; i < C; i++) {
            if (((x - E[i]) * (x - E[i]) + (y - F[i]) * (y - F[i])) <= (D * D))
                return true;
        }
        return false;
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

/*

Valid Path
Problem Description

There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjacent neighbours and we cannot move outside the boundary of the rectangle at any point of time.



Problem Constraints
0 <= x , y, R <= 100

1 <= N <= 1000

Center of each circle would lie within the grid



Input Format
1st argument given is an Integer x , denoted by A in input.

2nd argument given is an Integer y, denoted by B in input.

3rd argument given is an Integer N, number of circles, denoted by C in input.

4th argument given is an Integer R, radius of each circle, denoted by D in input.

5th argument given is an Array A of size N, denoted by E in input, where A[i] = x coordinate of ith circle

6th argument given is an Array B of size N, denoted by F in input, where B[i] = y coordinate of ith circle



Output Format
Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).



Example Input
Input 1:

 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]
Input 2:

 x = 1
 y = 1
 N = 1
 R = 1
 A = [1]
 B = [1]


Example Output
Output 1:

 NO
Output 2:

 NO


Example Explanation
Explanation 1:

 There is NO valid path in this case
Explanation 2:

 There is NO valid path in this case
 */