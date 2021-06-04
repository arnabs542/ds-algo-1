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

/*
2-Sum Binary Tree
Problem Description

Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.

Return 1 to denote that two such nodes exist. Return 0, otherwise.



Problem Constraints
1 <= size of tree <= 100000

1 <= B <= 109



Input Format
First argument is the head of the tree A.

Second argument is the integer B.



Output Format
Return 1 if such a pair can be found, 0 otherwise.



Example Input
Input 1:

         10
         / \
        9   20

B = 19
Input 2:


          10
         / \
        9   20

B = 40


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 10 + 9 = 19. Hence 1 is returned.
Explanation 2:

 No such pair exists.

 */
