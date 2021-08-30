package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LeftViewBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (A == null) {
            return ans;
        }
        TreeNode root = A;

        Deque<TreeNode> deque = new ArrayDeque<>(); //keep adding to queue
        deque.add(root);
        int size = 1;

        while (!deque.isEmpty()) {

            TreeNode parent = deque.pollFirst(); //for each pop, we are adding two more nodes to the queue

            //add left and right childs to queue
            if (parent.right != null) {
                deque.addLast(parent.right);
            }
            if (parent.left != null) {
                deque.addLast(parent.left);
            }
            if (--size == 0) {
                ans.add(parent.val); //add the leftmost to the ans, when size is 0
                size = deque.size(); //reset size to queue size
            }
        }
        return ans;
    }
}


