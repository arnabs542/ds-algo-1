package com.dsa.arrays;

import java.util.ArrayList;

public class RotateMatrix {
    public void solve(ArrayList<ArrayList<Integer>> a) {

        //this problem can also be solved by taking transpose of the matrix and reversing elements in all rows

        int N = a.size();
        //only N/2 iterations needed. For eg: for 4x4 matrix we take outer elements and another set of inner matrix's outer elements
        for (int i = 0; i < N / 2; i++) {

            //need to swap (j)*4 elements everytime
            //each of the 4 elements to be swapped are being swapped below
            for (int j = i; j < N - i - 1; j++) {

                Integer temp = a.get(i).get(j);

                //observation needed here to get the below formula
                a.get(i).set(j, a.get(N - j - 1).get(i));
                a.get(N - j - 1).set(i, a.get(N - i - 1).get(N - j - 1));
                a.get(N - i - 1).set(N - j - 1, a.get(j).get(N - i - 1));
                a.get(j).set(N - i - 1, temp);
            }
        }
    }
}
/*
Rotate Matrix
Problem Description

You are given a n x n 2D matrix A representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note: If you end up using an additional array, you will only receive partial score.



Problem Constraints
1 <= n <= 1000



Input Format
First argument is a 2D matrix A of integers



Output Format
Return the 2D rotated matrix.



Example Input
Input 1:

 [
    [1, 2],
    [3, 4]
 ]
Input 2:

 [
    [1]
 ]


Example Output
Output 1:

 [
    [3, 1],
    [4, 2]
 ]
Output 2:

 [
    [1]
 ]


Example Explanation
Explanation 1:

 After rotating the matrix by 90 degree:
 1 goes to 2, 2 goes to 4
 4 goes to 3, 3 goes to 1
Explanation 2:

 2D array remains the ssame as there is only element.

 */