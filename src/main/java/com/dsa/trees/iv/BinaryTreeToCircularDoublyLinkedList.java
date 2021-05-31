package com.dsa.trees.iv;

import com.dsa.trees.common.TreeNode;

public class BinaryTreeToCircularDoublyLinkedList {

    public TreeNode solve(TreeNode root) {
        Pair<TreeNode, TreeNode> ans = recurse(root);
        return ans.head;
    }

    private Pair<TreeNode, TreeNode> recurse(TreeNode curr) {

        if (curr == null) {
            return new Pair<>(null, null);
        }

        Pair<TreeNode, TreeNode> lt = recurse(curr.left);
        Pair<TreeNode, TreeNode> rt = recurse(curr.right);

        if (lt.head == null && rt.head == null) {
            return new Pair<>(curr, curr); //when left and right both null, head and tail will be curr itself
        } else if (lt.head == null) {
            curr.right = rt.head;
            rt.head.left = curr;
            return new Pair<>(curr, rt.tail); //when left is null and right non-null, head will be curr
        } else if (rt.head == null) {
            lt.tail.right = curr;
            curr.left = lt.tail;
            return new Pair<>(lt.head, curr); //when left is non-null and right null
        } else {
            lt.tail.right = curr;
            curr.left = lt.tail;

            curr.right = rt.head;
            rt.head.left = curr;
            return new Pair<>(lt.head, rt.tail); //when both non-null
        }
    }

    static class Pair<T, U> {
        T head;
        U tail;

        Pair(T head, U tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}

/*
Binary tree to Circular Doubly Linked List
Problem Description

Given a binary tree convert it into circular doubly linked list based on the following rules:

The left and right pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
The order of nodes in List must be same as Inorder of the given Binary Tree.
The first node of Inorder traversal must be the head node of the Circular List.
NOTE: You are expected to convert the binary tree into Doubly linked list in place.



Problem Constraints
1 <= Number of nodes in tree <= 100000

1 <= Value of node <= 109



Input Format
The only argument given is the root pointer of the tree, A.



Output Format
Return the head pointer of the converted circular doubly linked list.



Example Input
Input 1:

 Serialized from input of binary tree:(where 7 denotes the number of elements in serial)
    7 20 8 -1 -1 22 -1 -1
    Binary tree is
      20
     /  \
    8    22
    8 is the left child of 20 and 22 is the right child of 20.
Input 2:

 Serialized from input of binary tree:(where 7 denotes the number of elements in serial)
    7 10 8 -1 -1 11 -1 -1
    Binary tree is
      10
     /  \
    8    11
    8 is the left child of 10 and 11 is the right child of 10.


Example Output
Output 1:

     _____________
    |             |
    8 <-> 20 <-> 22
    |_____________|
Output 2:

     _____________
    |             |
    8 <-> 10 <-> 11
    |_____________|


Example Explanation
Explanation 1:

 The inorder traversal of binary tree is: [8, 20, 22]. Return the head pointer of the circular doubly linked list.
Explanation 2:

 The inorder traversal of binary tree is: [8, 10, 11]. Return the head pointer of the circular doubly linked list
 */
