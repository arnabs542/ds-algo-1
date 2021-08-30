package com.dsa.queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public String solve(String A) {

        StringBuilder ans = new StringBuilder();
        Queue<Character> queue = new ArrayDeque<>();

        int[] countArr = new int[26];//count of occurence of each char

        for (int i = 0; i < A.length(); i++) {
            countArr[A.charAt(i) - 'a']++; //increase count of char
            queue.add(A.charAt(i)); //add char to queue

            //keep removing from queue till we get a char which has count 1
            while (!queue.isEmpty() && countArr[queue.peek() - 'a'] != 1) {
                queue.remove();
            }
            if (queue.isEmpty()) {
                ans.append("#"); //append "#" if there is no char having count 1
            } else {
                ans.append(queue.peek());
            }
        }
        return ans.toString();
    }
}

