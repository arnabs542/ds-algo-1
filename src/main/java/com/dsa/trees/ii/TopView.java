package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class TopView {

    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) {
            return ans;
        }
        levelOrder(A); //do level order traversal, because lesser depth nodes have to appear first

        for (int i = min; i <= max; i++) { //no. of vertical  lines will be from min to max
            ans.add(map.get(i).get(0)); //just pick the first one
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
TOP VIEW
Problem Description

Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

Top view of a Binary Tree is a set of nodes visible when the tree is visited from top.

Return the nodes in any order.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the top view of the binary tree.



Example Input
Input 1:


            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
Input 2:


            1
           /  \
          2    3
           \
            4
             \
              5


Example Output
Output 1:

 [1, 2, 4, 8, 3, 7]
Output 2:

 [1, 2, 3]


Example Explanation
Explanation 1:

Top view is described.
Explanation 2:

Top view is described.

 */
