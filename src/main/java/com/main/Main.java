package com.main;

public class Main {

    public static void main(String[] args) {
//        ShortestDistanceInMaze p = new ShortestDistanceInMaze();
//
//        int[][] input = {
//                {0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
//                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
//                {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
//                {1, 0, 0, 0, 1, 1, 0, 0, 1, 0},
//                {1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
//                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
//        int[] source = {7,5};
//        int[] destination = {4,2};
//        p.solve( input, source, destination);

//        MinimumWeightedCycle m = new MinimumWeightedCycle();
//        int[][] input = {
//                {1, 2, 2},
//                {2, 3, 3},
//                {3, 4, 1},
//                {4, 1, 4},
//                {1, 3, 15}
//        };
//        m.solve(4, input);

//        TreeColoringWithThreeColors t = new TreeColoringWithThreeColors();
//        t.solve("22000");
//
//        AlternatePositiveNegativeElements a = new AlternatePositiveNegativeElements();
//
//        int[] inp = new int[]{-1, -2, -3, 4, 5};
//        a.solve(inp);

        int a = 6;
        int b = -a;
        int c = a & b;

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
    }
}




