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

