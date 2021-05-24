package com.graphs.v;

import java.util.Arrays;

public class TreeColoringWithThreeColors {

    private static final int GREEN_COLOR = 0;
    private static final int RED_COLOR = 1;
    private static final int BLUE_COLOR = 2;

    private int[][] maxDp;
    private int[][] minDp;
    private int pointer;

    public int[] solve(String A) {

        maxDp = new int[A.length()][3];
        minDp = new int[A.length()][3];

        for (int i = 0; i < maxDp.length; i++) {
            Arrays.fill(maxDp[i], -1);
            Arrays.fill(minDp[i], -1);
        }

        pointer = 0;
        TreeNode root = constructTree(A);
        int[] ans1 = colorTree(root, GREEN_COLOR);
        int[] ans2 = colorTree(root, RED_COLOR);
        int[] ans3 = colorTree(root, BLUE_COLOR);

        System.out.println(Arrays.toString(ans1));
        System.out.println(Arrays.toString(ans2));
        System.out.println(Arrays.toString(ans3));

        int max = Math.max(ans1[0], Math.max(ans2[0], ans3[0]));
        int min = Math.min(ans1[1], Math.min(ans2[1], ans3[1]));

        return new int[]{max, min};
    }

    //returns an array of two integers, first has max greens, second has min greens
    private int[] colorTree(TreeNode root, int color) {

        if (root == null) {
            return new int[]{0, 0};
        }

        if (minDp[root.index][color] != -1) {
            return new int[]{maxDp[root.index][color], minDp[root.index][color]};
        }

        int maxGreens;
        int minGreens;

        if (color == GREEN_COLOR) {
            int[] ans1 = colorTree(root.left, RED_COLOR);
            int[] ans2 = colorTree(root.right, BLUE_COLOR);

            int[] ans3 = colorTree(root.left, BLUE_COLOR);
            int[] ans4 = colorTree(root.right, RED_COLOR);

            maxGreens = 1 + Math.max(ans1[0] + ans2[0], ans3[0] + ans4[0]);
            minGreens = 1 + Math.min(ans1[1] + ans2[1], ans3[1] + ans4[1]);

        } else if (color == BLUE_COLOR) {
            int[] ans1 = colorTree(root.left, RED_COLOR);
            int[] ans2 = colorTree(root.right, GREEN_COLOR);

            int[] ans3 = colorTree(root.left, GREEN_COLOR);
            int[] ans4 = colorTree(root.right, RED_COLOR);

            maxGreens = Math.max(ans1[0] + ans2[0], ans3[0] + ans4[0]);
            minGreens = Math.min(ans1[1] + ans2[1], ans3[1] + ans4[1]);
        } else {
            int[] ans1 = colorTree(root.left, GREEN_COLOR);
            int[] ans2 = colorTree(root.right, BLUE_COLOR);

            int[] ans3 = colorTree(root.left, BLUE_COLOR);
            int[] ans4 = colorTree(root.right, GREEN_COLOR);

            maxGreens = Math.max(ans1[0] + ans2[0], ans3[0] + ans4[0]);
            minGreens = Math.min(ans1[1] + ans2[1], ans3[1] + ans4[1]);
        }

        maxDp[root.index][color] = maxGreens;
        minDp[root.index][color] = minGreens;

        return new int[]{maxGreens, minGreens};
    }

    private TreeNode constructTree(String A) {

        TreeNode node = new TreeNode(pointer);

        if (A.charAt(pointer) == '0') { //no more children
            pointer++;
            return node;
        } else if (A.charAt(pointer) == '1') {
            pointer++;
            node.left = constructTree(A);
            return node;
        } else {
            pointer++;
            node.left = constructTree(A);
            node.right = constructTree(A);
            return node;
        }
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int index;

        TreeNode(int i) {
            this.index = i;
        }
    }
}

/*
Tree coloring with three colors
Problem Description

Given a string A specifying a tree. A tree consists of a node and some (zero, one or two) subtrees connected to it. These subtrees are called children. A specification of the tree is a sequence of digits.

If the number of children in the tree is:

zero, then the specification is a sequence with only one element '0'.

one, the specification begins with '1' followed by the specification of the child.

two, the specification begins with '2' followed by the specification of the first child, and then by the specification of the second child.

You have to color the nodes of the tree. Each of the nodes in the tree must be painted either red or green or blue.

Following are some rules while painting the nodes:

The vertex and its child cannot have the same color.

If a vertex has two children, then they must have different colors.

return an array of integer C of size 2 where

C[0] = maximum number of nodes that can be painted green

C[1] = minimum number of nodes that can be painted green



Problem Constraints
1 <= length of the string <= 100000

A[i] = { '0', '1', '2'}



Input Format
The only argument given is string A.



Output Format
Return an array of integer C.



Example Input
Input 1:


A = 1122002010
Input 2:

A = 22000


Example Output
Output 1:

C = [5, 2]
Output 2:


C = [2, 1]


Example Explanation
Explanation 1:

A maximum of 5 and a minimum of 2 nodes can be green.
Explanation 2:

A maximum of 2 and a minimum of 1 nodes can be green.
 */
