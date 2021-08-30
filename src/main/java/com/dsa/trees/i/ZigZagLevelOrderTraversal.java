package com.dsa.trees.i;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ZigZagLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        //same approach as level order traversal, just need to alternatively reverse while adding to ans
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (A == null) {
            return ans;
        }

        TreeNode root = A;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int size = 1;

        ArrayList<Integer> level = new ArrayList<>();

        boolean reverse = false;
        while (!deque.isEmpty()) {

            TreeNode parent;

            if (reverse) {
                parent = deque.pollLast();
                if (parent.right != null) {
                    deque.addFirst(parent.right);
                }
                if (parent.left != null) {
                    deque.addFirst(parent.left);
                }
            } else {
                parent = deque.pollFirst();
                if (parent.left != null) {
                    deque.addLast(parent.left);
                }
                if (parent.right != null) {
                    deque.addLast(parent.right);
                }
            }
            level.add(parent.val);

            if (--size == 0) {
                reverse = !reverse;
                ans.add(new ArrayList<>(level));
                level.clear();
                size = deque.size();
            }
        }
        return ans;
    }
}

