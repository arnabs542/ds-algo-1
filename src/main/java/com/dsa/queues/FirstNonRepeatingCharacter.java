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
/*
First non-repeating character
Problem Description

Given a string A denoting a stream of lowercase alphabets.

You have to make new string B. B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. if no non-repeating character is found then append '#' at the end of B.



Problem Constraints
1 <= |A| <= 100000



Input Format
The only argument given is string A.



Output Format
Return a string B after processing the stream of lowercase alphabets A.



Example Input
Input 1:

 A = "abadbc"
Input 2:

 A = "abcabc"


Example Output
Output 1:

"aabbdd"
Output 2:

"aaabc#"


Example Explanation
Explanation 1:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"aba"    -   first non repeating character 'b'
"abad"   -   first non repeating character 'b'
"abadb"  -   first non repeating character 'd'
"abadbc" -   first non repeating character 'd'
Explanation 2:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"abc"    -   first non repeating character 'a'
"abca"   -   first non repeating character 'b'
"abcab"  -   first non repeating character 'c'
"abcabc" -   no non repeating character so '#'

 */
