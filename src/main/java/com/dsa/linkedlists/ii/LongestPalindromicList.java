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
