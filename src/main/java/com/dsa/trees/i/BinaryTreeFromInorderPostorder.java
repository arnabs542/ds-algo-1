package com.dsa.trees.i;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTreeFromInorderPostorder {

    private HashMap<Integer, Integer> map = new HashMap<>(); //stores element and its index in inorder array
    private int index = -1; //to traverse postorder array

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        for (int i = 0; i < A.size(); i++) { //put in map
            map.put(A.get(i), i);
        }
        index = B.size() - 1; //last element in postorder will be root

        return getTree(0, index, A, B);
    }

    //start and end indicate indices in inorder array
    private TreeNode getTree(int start, int end, ArrayList<Integer> A, ArrayList<Integer> B) {

        if (A.isEmpty() || start > end) {//no more elements left
            return null;
        }

        int curr = B.get(index--); //last element in postorder will be root
        int inorderPos = map.get(curr); //index of curr in inorder array

        TreeNode ans = new TreeNode(curr); //create node with current as root

        //traverse right first as we know what will be the right
        ans.right = getTree(inorderPos + 1, end, A, B); //inorderPos + 1 till end will be elements in right to curr
        ans.left = getTree(start, inorderPos - 1, A, B); //start till inorderPos - 1 will be elements in left to curr

        return ans;
    }
}

/*
Binary Tree From Inorder And Postorder
Problem Description

Given inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]


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