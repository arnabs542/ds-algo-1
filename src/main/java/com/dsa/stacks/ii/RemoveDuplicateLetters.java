package com.dsa.stacks.ii;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String solve(String A) {

        int[] lastOccurence = new int[26]; //count of chars
        for (int i = 0; i < A.length(); i++) {
            lastOccurence[A.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26]; //visited flags for chars
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            int c = A.charAt(i) - 'a';

            if (!visited[c]) {
                //if current char is lesser than stack.top and there are other occurences of stack.top char, pop it and mark visited as false
                while (!stack.empty() && (stack.peek() > A.charAt(i))
                        && (lastOccurence[stack.peek() - 'a'] > i)) {
                    visited[stack.pop() - 'a'] = false;
                }
                visited[c] = true; //mark char as visited
                stack.push(A.charAt(i)); //push to stack
            }
        }
        StringBuilder ans = new StringBuilder("");
        for (char c : stack) {
            ans.append(c);
        }
        return ans.toString();
    }
}
