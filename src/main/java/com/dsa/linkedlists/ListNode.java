package com.dsa.linkedlists;

public class ListNode {
    public int val;
    public ListNode next, random, down;

    public ListNode(int x) {
        val = x;
        next = random = down = null;
    }
}
