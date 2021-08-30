package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

import java.util.Stack;

public class CommonNodesInTwoBST {

    private Stack<TreeNode> firstBST = new Stack<>();
    private Stack<TreeNode> secondBST = new Stack<>();

    public int solve(TreeNode A, TreeNode B) {

        int mod = 1000000007;
        long ans = 0L;

        //good idea similar to two pointer approach, works because BST
        addToStack(A, true);
        addToStack(B, false);

        while (!firstBST.empty() && !secondBST.empty()) {
            TreeNode node1 = firstBST.peek();
            TreeNode node2 = secondBST.peek();

            if (node1.val == node2.val) {
                ans = (ans + node1.val) % mod;
                node1 = firstBST.pop();
                node2 = secondBST.pop();
                addToStack(node1.right, true);
                addToStack(node2.right, false);
            } else if (node1.val < node2.val) {
                node1 = firstBST.pop();
                addToStack(node1.right, true);
            } else {
                node1 = secondBST.pop();
                addToStack(node1.right, false);
            }
        }
        return (int) ans;
    }

    private void addToStack(TreeNode root, boolean toFirstBST) {
        if (toFirstBST) {
            while (root != null) {
                firstBST.push(root);
                root = root.left;
            }
        } else {
            while (root != null) {
                secondBST.push(root);
                root = root.left;
            }
        }
    }
}


