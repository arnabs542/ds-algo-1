package com.dsa.trees.i;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTreeFromInorderPreorder {

    private HashMap<Integer, Integer> map = new HashMap<>(); //stores element and its index in inorder array
    private int index = -1; //to traverse preorder array

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        for (int i = 0; i < B.size(); i++) {
            map.put(B.get(i), i);
        }

        index = 0; //first element in preorder will be root

        return getTree(0, B.size() - 1, A, B);
    }

    //start and end indicate indices in inorder array
    private TreeNode getTree(int start, int end, ArrayList<Integer> A, ArrayList<Integer> B) {

        if (B.isEmpty() || start > end) {//no more elements left
            return null;
        }

        int curr = A.get(index++); //first element in preorder will be root
        int inorderPos = map.get(curr); //index of curr in inorder array

        TreeNode ans = new TreeNode(curr); //create node with current as root

        //traverse left first as we know what will be the root
        ans.left = getTree(start, inorderPos - 1, A, B); //start till inorderPos - 1 will be elements in left to curr
        ans.right = getTree(inorderPos + 1, end, A, B); //inorderPos + 1 till end will be elements in right to curr

        return ans;
    }

}

/*
Binary Tree From Inorder And Preorder
Problem Description

Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the preorder traversal of the tree.

Second argument is an integer array B denoting the inorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:

 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]


Example Output
Output 1:

   1
  / \
 2   3
Output 2:

   1
  / \
 6   2
    /
   3


Example Explanation
Explanation 1:

 Create the binary tree and return the root node of the tree.
 */