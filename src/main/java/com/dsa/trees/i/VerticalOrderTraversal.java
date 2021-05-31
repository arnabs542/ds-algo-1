package com.dsa.trees.i;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class VerticalOrderTraversal {

    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A == null) {
            return ans;
        }
        levelOrder(A); //do level order traversal, because lesser depth nodes have to appear first

        for (int i = min; i <= max; i++) { //no. of vertical  lines will be from min to max
            ans.add(new ArrayList<>(map.get(i)));
        }

        return ans;
    }

    public void levelOrder(TreeNode curr) {

        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>(); //queue stores a pair of node and its vertical index
        deque.add(new Pair<>(curr, 0));

        while (!deque.isEmpty()) {

            Pair<TreeNode, Integer> parent = deque.pollFirst();

            max = Math.max(max, parent.verticalIndex); //update max
            min = Math.min(min, parent.verticalIndex); //update min

            if (parent.node.left != null) { //for left nodes, decrease vertical index
                deque.addLast(new Pair<>(parent.node.left, parent.verticalIndex - 1));
            }
            if (parent.node.right != null) { //for right nodes, increase vertical index
                deque.addLast(new Pair<>(parent.node.right, parent.verticalIndex + 1));
            }

            //update map with current node
            ArrayList<Integer> values = map.getOrDefault(parent.verticalIndex, new ArrayList<>());
            values.add(parent.node.val);
            map.put(parent.verticalIndex, values);
        }
    }

    static class Pair<T, U> {
        T node;
        U verticalIndex;

        Pair(T node, U verticalIndex) {
            this.node = node;
            this.verticalIndex = verticalIndex;
        }
    }
}

/*
Vertical Order traversal
Problem Description

Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints
0 <= number of nodes <= 105



Input Format
First and only arument is a pointer to the root node of binary tree, A.



Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

      1
    /   \
   3     7
  /       \
 2         9


Example Output
Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation
Explanation 1:

 First row represent the verical line 1 and so on.

 */