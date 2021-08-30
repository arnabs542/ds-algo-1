package com.dsa.trees.i;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

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

