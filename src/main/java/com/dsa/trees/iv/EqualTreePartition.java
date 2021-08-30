package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

import java.util.Stack;

public class EqualTreePartition {

    private boolean isPossible = false;

    public int solve(TreeNode A) {

        int total = totalSum(A);
        if (total % 2 != 0) {
            return 0;
        }
        subTreeSum(A, A, total / 2);
        return isPossible ? 1 : 0;
    }

    private int subTreeSum(TreeNode root, TreeNode curr, int sum) {

        if (isPossible) { //no need to recurse, as we found already that its possible
            return -1;
        }
        if (curr == null) {
            return 0;
        }
        int lt = subTreeSum(root, curr.left, sum);
        int rt = subTreeSum(root, curr.right, sum);

        int currTotal = lt + rt + curr.val;

        // when total sum of tree is 0, then toAchieve is also 0, need to check for other subtrees with sum 0, so put curr != root
        if (currTotal == sum && curr != root) {
            isPossible = true;
        }
        return currTotal;
    }

    private int totalSum(TreeNode root) {

        int sum = 0;

        //preorder traversal to sum all nodes
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                sum += curr.val;
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                curr = temp.right;
            }
        }
        return sum;
    }
}


