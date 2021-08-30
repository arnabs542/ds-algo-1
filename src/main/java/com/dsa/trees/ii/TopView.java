package com.dsa.trees.ii;

import com.dsa.trees.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class TopView {

    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    private HashMap<Integer, Integer> map = new HashMap<>();

    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) {
            return ans;
        }
        levelOrder(A); //do level order traversal, because lesser depth nodes have to appear first

        for (int i = min; i <= max; i++) { //no. of vertical  lines will be from min to max
            ans.add(map.get(i)); //just pick the first one
        }
        return ans;
    }

    public void levelOrder(TreeNode curr) {

        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>(); //queue stores a pair of node and its vertical index
        deque.add(new Pair<>(curr, 0));

        while (!deque.isEmpty()) {

            Pair<TreeNode, Integer> parent = deque.pollFirst();

            max = Math.max(max, parent.verticalIndex); //update max
            min = Math.min(min, parent.verticalIndex); //update min

            if (parent.node.left != null) { //for left nodes, decrease vertical index
                deque.addLast(new Pair<>(parent.node.left, parent.verticalIndex - 1));
            }
            if (parent.node.right != null) { //for right nodes, increase vertical index
                deque.addLast(new Pair<>(parent.node.right, parent.verticalIndex + 1));
            }

            //update map with current node
            Integer top = map.getOrDefault(parent.verticalIndex, -1);
            if (top.equals(-1)) {
                map.put(parent.verticalIndex, parent.node.val);
            }
        }
    }

    static class Pair<T, U> {
        T node;
        U verticalIndex;

        Pair(T node, U verticalIndex) {
            this.node = node;
            this.verticalIndex = verticalIndex;
        }
    }
}


