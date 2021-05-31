package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

import java.util.HashSet;
import java.util.Stack;

public class TwoSumBinaryTree {

    public int t2Sum(TreeNode A, int B) {

        HashSet<Integer> set = new HashSet<>(); //set stores visited values

        //iterative preorder traversal
        TreeNode curr = A;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || curr != null) {
            if (curr != null) {
                if (set.contains(B - curr.val)) {
                    return 1;
                } else {
                    set.add(curr.val);
                }
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                curr = temp.right;
            }
        }
        return 0;
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
