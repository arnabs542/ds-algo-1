package com.dsa.stacks.i;

import java.util.ArrayList;
import java.util.Stack;

public class SortStackUsingStack {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        Stack<Integer> stack = new Stack<>(); //stack that will have sorted integers

        int top = A.size() - 1; //index pointing to top of input stack

        while (top > -1) {
            int currVal = A.get(top); //current elem of input stack
            while (!stack.empty() && (stack.peek() > currVal)) { //if output stack top elem > incoming element, pop and push to input stack
                A.set(top++, stack.pop());
            }
            stack.push(currVal); //push curr elem to output stack
            top--;
        }
        return new ArrayList<>(stack);
    }
}
/*
Sort stack using another stack
Problem Description

Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints
1 <= |A| <= 5000

0 <= A[i] <= 1000000000



Input Format
The only argument given is the integer array A.



Output Format
Return the array of integers after sorting the stack using another stack.



Example Input
Input 1:

 A = [5, 4, 3, 2, 1]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 [1, 2, 3, 4, 5]
Output 2:

 [5, 11, 17, 100]


Example Explanation
Explanation 1:

 Just sort the given numbers.
Explanation 2:

 Just sort the given numbers.
 */