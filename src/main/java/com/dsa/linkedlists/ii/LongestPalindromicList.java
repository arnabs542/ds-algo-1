package com.dsa.linkedlists.ii;

import com.dsa.linkedlists.ListNode;

public class LongestPalindromicList {

    public int solve(ListNode A) {

        int maxLength = -1;

        ListNode prev = null;
        ListNode curr = A;
        ListNode next = A.next;

        while (next != null) {
            curr.next = prev;

            int even = matchLLs(curr, next); //for even length palindrome
            int odd = matchLLs(prev, next); //for odd length palindrome
            maxLength = Math.max(maxLength, Math.max(2 * even, 2 * odd + 1)); //update maxLength

            //update pointers
            prev = curr;
            curr = next;
            next = next.next;
        }
        return maxLength;
    }

    //returns length till which both LLs are matching
    private int matchLLs(ListNode A, ListNode B) {
        int length = 0;

        ListNode tempA = A;
        ListNode tempB = B;

        while (tempA != null && tempB != null) {
            if (tempA.val == tempB.val) {
                length++;
            } else {
                break;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return length;
    }
}
/*
Longest Palindromic List
Problem Description

Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.

A palindrome list is a list that reads the same backward and forward.

Expected memory complexity : O(1)



Problem Constraints
1 <= length of the linked list <= 2000

1 <= Node value <= 100



Input Format
The only argument given is head pointer of the linked list.



Output Format
Return the length of the longest palindrome list.



Example Input
Input 1:

 2 -> 3 -> 3 -> 3
Input 2:

 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2


Example Output
Output 1:

 3
Output 2:

 5


Example Explanation
Explanation 1:

 3 -> 3 -> 3 is largest palindromic sublist
Explanation 2:

 2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.

 */