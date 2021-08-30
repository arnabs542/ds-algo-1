package com.dsa.trees.i;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();  //use stack to store visited nodes  n L R
        TreeNode curr = A;

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                ans.add(curr.val);
                stack.push(curr); //save to stack as we need to go right later
                curr = curr.left; //go left
            } else {
                TreeNode temp = stack.pop(); //pop and go right
                curr = temp.right;
            }
        }
        return ans;
    }

    // Morris preorder traversal

}

