package com.dsa.graphs.v;

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


