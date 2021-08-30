package com.dsa.stacks.i;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFrequencyStack {
    public int[] solve(int[][] A) {

        int[] ans = new int[A.length];

        Map<Integer, Integer> elemMap = new HashMap<>(); //key: element, value: frequency of element
        Map<Integer, Stack<Integer>> freqMap = new HashMap<>(); //key: frequency, value: Stack of elements

        int maxFreq = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {

            if (A[i][0] == 1) { //push operation

                int elem = A[i][1]; //curr elem
                elemMap.put(elem, elemMap.getOrDefault(elem, 0) + 1); //update elem frequency

                int freq = elemMap.get(elem); //freq of elem
                freqMap.computeIfAbsent(freq, z -> new Stack<>()).push(elem);
                maxFreq = Math.max(maxFreq, freq); //update max freq

                ans[i] = -1;
            } else {

                Stack<Integer> stack = freqMap.get(maxFreq);
                int elem = stack.pop(); //get top stack elem of maxFreqStack

                if (stack.empty()) { //stack is empty means no more elems in curr freq, so reduce it by 1
                    maxFreq--;
                }
                elemMap.put(elem, elemMap.getOrDefault(elem, 0) - 1);
                ans[i] = elem;
            }
        }
        return ans;
    }
}

