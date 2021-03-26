package apo.java.practice.leetcode.challenge;

import java.util.Random;

public class LinkedListRandomNode {

    private final int[] values = new int[10000];
    private final Random random = new Random();
    private int size = 0;

    public LinkedListRandomNode(ListNode head) {
	do {
	    values[size++] = head.val;
	} while ((head = head.next) != null);
    }

    public int getRandom() {
	return values[random.nextInt(size)];
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
	this.val = val;
    }

    ListNode(int val, ListNode next) {
	this.val = val;
	this.next = next;
    }
}
