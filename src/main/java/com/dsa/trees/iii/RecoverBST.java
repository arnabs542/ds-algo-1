package com.dsa.trees.iii;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class RecoverBST {

    public int[] recoverTree(TreeNode A) {

        ArrayList<Integer> inorder = inorderTraversal(A); //would have been sorted if no reversing happened

        int x = -1; //min val
        int y = -1; //max val

        //find the two pairs where sorted order breaks
        for (int i = 1; i < inorder.size(); i++) {
            if (x == -1 && y == -1 && inorder.get(i) < inorder.get(i - 1)) { //max elem in first pair and min elem in second pair is the ans
                x = inorder.get(i);
                y = inorder.get(i - 1);
            } else if (inorder.get(i) < inorder.get(i - 1)) { //only update the min elem
                x = inorder.get(i);
            }
        }

        return new int[]{x, y};

//        Stack<TreeNode> stack = new Stack<>(); //store visited elements, to print L n R
//        TreeNode x = null, y = null, prev = null; //prev only while printing i.e popping
//
//        while (A != null || !stack.empty()) {
//            if (A != null) {
//                stack.push(A);
//                A = A.left;  //keep going left
//            } else {
//                TreeNode temp = stack.pop(); //pop from stack and add to ans
//                if(prev != null && prev.val > temp.val) {
//                    y = temp;
//                    if(x == null) {
//                        x = prev;
//                    } else {
//                        break;
//                    }
//                }
//                prev = temp;
//                A = temp.right; //go right
//            }
//        }
//        //swap x,y
//        int temp = x.val;
//        x.val = y.val;
//        y.val = temp;
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>(); //store visited elements, to print them later   L n R
        TreeNode curr = A;

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;  //keep going left
            } else {
                TreeNode temp = stack.pop(); //pop from stack and add to ans
                ans.add(temp.val);
                curr = temp.right; //go right
            }
        }
        return ans;
    }
}

/*
Recover Binary Search Tree
Problem Description

Two elements of a binary search tree (BST),represented by root A are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.

A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?



Problem Constraints
1 <= size of tree <= 100000



Input Format
First and only argument is the head of the tree,A



Output Format
Return the 2 elements which need to be swapped.



Example Input
Input 1:


         1
        / \
       2   3
Input 2:


         2
        / \
       3   1



Example Output
Output 1:

 [2, 1]
Output 2:

 [3, 1]


Example Explanation
Explanation 1:

Swapping 1 and 2 will change the BST to be
         2
        / \
       1   3
which is a valid BST
Explanation 2:

Swapping 1 and 3 will change the BST to be
         2
        / \
       1   3
which is a valid BST

 */
