package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

import java.util.Stack;

public class TwoSumBST {

    private Stack<TreeNode> forward = new Stack<>();
    private Stack<TreeNode> backward = new Stack<>();

    public int t2Sum(TreeNode A, int B) {

        //good idea similar to two pointer approach, works because BST
        addToStack(A, true);
        addToStack(A, false);

        while (!forward.empty() && !backward.empty()) {
            TreeNode node1 = forward.peek();
            TreeNode node2 = backward.peek();

            if (node1.val == node2.val) {
                return 0;
            } else if (node1.val + node2.val < B) {
                node1 = forward.pop();
                if (node1.right != null) {
                    addToStack(node1.right, true);
                }
            } else if (node1.val + node2.val > B) {
                node1 = backward.pop();
                if (node1.left != null) {
                    addToStack(node1.left, false);
                }
            } else {
                return 1;
            }
        }
        return 0;
    }

    private void addToStack(TreeNode root, boolean isForward) {
        if (isForward) {
            while (root != null) {
                forward.push(root);
                root = root.left;
            }
        } else {
            while (root != null) {
                backward.push(root);
                root = root.right;
            }
        }
    }
}


