package com.graphs.iii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ShortestDistanceInMaze {

    private int[] rows = new int[]{0, -1, 0, 1}; //go -> left, up, right, down
    private int[] cols = new int[]{-1, 0, 1, 0};

    public int solve(int[][] A, int[] B, int[] C) {

        //3rd dimension true if visited from -> right(0), down(1), left(2), up(3)
        boolean[][][] visited = new boolean[A.length][A[0].length][4];

        //queue for doing BFS
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(null, B[0], B[1], Direction.UNKNOWN));

        int level = 1;
        int size = 1;

        while (!deque.isEmpty()) {

            Node current = deque.pollFirst();
            size--;

            List<Node> nextPossibilities = getNextPossibleNeighbours(A, current); //where all it can go

            for (Node next : nextPossibilities) {
                //if found destination, return only if ball can stop
                if (next.i == C[0] && next.j == C[1] && (getNextPossibleInSameDirection(A, next)) == null) {
                    return level;
                }
                // visit only if not visited already
                if (!visited[next.i][next.j][next.fromDirection.identifier]) {
                    visited[next.i][next.j][next.fromDirection.identifier] = true;
                    deque.addLast(next);
                }
            }
            if (size == 0 && !deque.isEmpty()) {
                level++;
                size = deque.size();
            }
        }
        return -1;
    }

    private List<Node> getNextPossibleNeighbours(int[][] A, Node current) {

        List<Node> possibleNeighbours = new ArrayList<>();
        Node nextPossibleInSameDirection = getNextPossibleInSameDirection(A, current);

        if (nextPossibleInSameDirection == null) { //has to change direction implies multiple neighbours possible
            for (int k = 0; k < rows.length; k++) {

                int nexti = current.i + rows[k];
                int nextj = current.j + cols[k];

                Node next = new Node(current, nexti, nextj, Direction.get(k));

                if (nexti >= 0 && nexti < A.length && nextj >= 0 && nextj < A[0].length
                        && A[next.i][next.j] == 0) {
                    possibleNeighbours.add(next);
                }
            }
        } else { //only single possibility as ball has to follow same direction
            possibleNeighbours.add(nextPossibleInSameDirection);
        }
        return possibleNeighbours;
    }

    //returns the next traversable node in the same direction as of (node) and (node.previous)
    //returns null if cant traverse in same direction
    private Node getNextPossibleInSameDirection(int[][] A, Node node) {

        if (node.previous == null) { //if previous is null, can't determine direction so return null
            return null;
        }
        if ((node.previous.i == node.i) && (node.previous.j < node.j)) { //came to node from left

            //check if can go to right node to follow same direction
            if (!((node.j + 1) >= A[0].length || (A[node.i][node.j + 1] == 1))) {
                return new Node(node, node.i, node.j + 1, Direction.FROM_LEFT);
            }
        } else if ((node.previous.i < node.i) && (node.previous.j == node.j)) { //came to node from up

            //check if can go to down node to follow same direction
            if (!((node.i + 1) >= A.length || (A[node.i + 1][node.j] == 1))) {
                return new Node(node, node.i + 1, node.j, Direction.FROM_UP);
            }
        } else if ((node.previous.i == node.i) && (node.previous.j > node.j)) { //came to node from right

            //check if can go to left node to follow same direction
            if (!((node.j - 1) < 0 || (A[node.i][node.j - 1] == 1))) {
                return new Node(node, node.i, node.j - 1, Direction.FROM_RIGHT);
            }
        } else if ((node.previous.i > node.i) && (node.previous.j == node.j)) { //came to node from down

            //check if can go to up node to follow same direction
            if (!((node.i - 1) < 0 || (A[node.i - 1][node.j] == 1))) {
                return new Node(node, node.i - 1, node.j, Direction.FROM_DOWN);
            }
        }
        return null;
    }

    enum Direction {
        UNKNOWN(-1),
        FROM_RIGHT(0),
        FROM_DOWN(1),
        FROM_LEFT(2),
        FROM_UP(3);

        private int identifier;

        Direction(int i) {
            this.identifier = i;
        }

        public static Direction get(int k) {
            for (Direction direction : Direction.values()) {
                if (k == direction.identifier) {
                    return direction;
                }
            }
            return Direction.UNKNOWN;
        }
    }

    static class Node {
        Node previous;
        int i, j;
        Direction fromDirection; //tells from which direction we arrived at this node

        Node(Node previous, int i, int j, Direction fromDirection) {
            this.i = i;
            this.j = j;
            this.previous = previous;
            this.fromDirection = fromDirection;
        }
    }
}

/*
Shortest Distance in a Maze
Problem Description

Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.

Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.



Problem Constraints
2 <= N, M <= 100

0 <= A[i] <= 1

0 <= B[i][0], C[i][0] < N

0 <= B[i][1], C[i][1] < M



Input Format
The first argument given is the integer matrix A.

The second argument given is an array of integer B.

The third argument if an array of integer C.



Output Format
Return a single integer, the minimum distance required to reach destination



Example Input
Input 1:

A = [ [0, 0], [0, 0] ]
B = [0, 0]
C = [0, 1]
Input 2:

A = [ [0, 0], [0, 1] ]
B = [0, 0]
C = [0, 1]


Example Output
Output 1:

 1
Output 2:

 1


Example Explanation
Explanation 1:

 Go directly from start to destination in distance 1.
Explanation 2:

 Go directly from start to destination in distance 1.

 */
