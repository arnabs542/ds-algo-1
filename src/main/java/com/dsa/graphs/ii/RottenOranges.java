package com.dsa.graphs.ii;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottenOranges {

    boolean[][] visited;
    //better way to handle allowed neighbours
    int[] rows = new int[]{-1, 0, 1, 0};
    int[] cols = new int[]{0, -1, 0, 1};

    public int solve(int[][] A) {

        //queue to do BFS
        Deque<Pair> deque = new ArrayDeque<>();
        visited = new boolean[A.length][A[0].length];

        //add all rotten oranges to the queue (this will be first level)
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    deque.addLast(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        int size = deque.size();

        while (!deque.isEmpty()) {

            Pair curNode = deque.pollFirst();
            size--;

            for (int k = 0; k < 4; k++) { //go in all directions
                int nextI = curNode.i + rows[k];
                int nextJ = curNode.j + cols[k];
                //do bfs only if neighbour is 1
                if (nextI >= 0 && nextI < A.length && nextJ >= 0 && nextJ < A[0].length && !visited[nextI][nextJ] && A[nextI][nextJ] == 1) {
                    A[nextI][nextJ] = 2;
                    visited[nextI][nextJ] = true;
                    deque.addLast(new Pair(nextI, nextJ));
                }
            }

            //update level once one level finishes and more items left
            if (size == 0 && !deque.isEmpty()) {
                level++;
                size = deque.size();
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    return -1;
                }
            }
        }
        return level;
    }

    //pair to store i and j of matrix
    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

