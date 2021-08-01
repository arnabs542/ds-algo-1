package com.dsa.backtracking.i;

import java.util.ArrayList;

public class Sudoku {

    private int size; //sudoku size
    private boolean[][] rows; //stores which no. is used up in the row
    private boolean[][] cols; //stores which no. is used up in the column
    private boolean[][] blocks; //stores which no. is used up in the blocks
    private boolean done = false;

    public void solveSudoku(ArrayList<ArrayList<Character>> A) {
        size = A.size();
        rows = new boolean[size][10];
        cols = new boolean[size][10];
        blocks = new boolean[size][10];

        //mark boolean arrays with true for already present values in input
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (A.get(i).get(j) != '.') {
                    int blockNo = ((i / 3) * 3) + (j / 3);//block no. to which cell(i,j) belongs
                    int no = A.get(i).get(j) - '0';
                    rows[i][no] = true;
                    cols[j][no] = true;
                    blocks[blockNo][no] = true;
                }
            }
        }
        recurse(0, A);
    }

    private void recurse(int currentCell, ArrayList<ArrayList<Character>> A) {

        int i = currentCell / size;//row no. in sudoku
        int j = currentCell % size;//col no. in sudoku
        int blockNo = ((i / 3) * 3) + (j / 3);//block no. to which cell(i,j) belongs

        if (currentCell == 81) {
            done = true;
            return;
        }

        //no need of making a choice for values present in input, so just recurse
        if (A.get(i).get(j) != '.') {
            recurse(currentCell + 1, A);
        } else {

            //check if no.s 1 to 9 can be placed
            for (int no = 1; no <= 9; no++) {

                if (!rows[i][no] && !cols[j][no] && !blocks[blockNo][no]) {

                    A.get(i).set(j, (char) (no + '0'));
                    rows[i][no] = true;
                    cols[j][no] = true;
                    blocks[blockNo][no] = true;

                    //check for next cell
                    recurse(currentCell + 1, A);

                    if (done) {
                        return; //to stop further recursions as we reached a solution
                    }

                    //backtrack
                    A.get(i).set(j, '.');
                    rows[i][no] = false;
                    cols[j][no] = false;
                    blocks[blockNo][no] = false;
                }
            }
        }
    }
}
/*
Sudoku
Problem Description

Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.



A sudoku puzzle,



and its solution numbers marked in red.



Problem Constraints
N = 9


Input Format
First argument is an array of array of characters representing the Sudoku puzzle.


Output Format
Modify the given input to the required answer.


Example Input
Input 1:

A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]


Example Output
Output 1:

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]


Example Explanation
Explanation 1:

Look at the diagrams given in the question.

 */
