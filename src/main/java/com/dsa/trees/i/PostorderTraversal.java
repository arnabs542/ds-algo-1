package com.dsa.trees.i;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostorderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>(); //store visited nodes in stack, as we will need them later
        TreeNode curr = A;

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                ans.add(curr.val);
                stack.push(curr);
                curr = curr.right; //go right, as we want preorder of mirror-imaged tree
            } else {
                TreeNode temp = stack.pop();
                curr = temp.left;
            }
        }
        Collections.reverse(ans); //postorder = Reverse of (preorder of mirror-imaged tree)
        return ans;
    }
}

