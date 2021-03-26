package apo.java.practice.leetcode.challenge;

public class MergeTwoSortedList {
    public static void main(String[] args) {
	var listNode = new ListNode(1, new ListNode(2, new ListNode(4)));
	var listNode1 = new ListNode(1, new ListNode(3, new ListNode(4)));
	var result = mergeTwoLists(listNode, listNode1);
    }

    public static ListNode mergeTwoLists(ListNode listNode, ListNode listNode1) {
	ListNode head, tail;
	if (listNode == null) {
	    return listNode1;
	}
	if (listNode1 == null) {
	    return listNode;
	}
	if (listNode.val < listNode1.val) {
	    head = listNode;
	    tail = listNode1;
	} else {
	    head = listNode1;
	    tail = listNode;
	}
	var result = head;
	while (tail != null) {
	    if (head.next == null) {
		head.next = tail;
		break;
	    }
	    var bar = head.next;
	    while (tail != null && tail.val <= bar.val) {
		head.next = tail;
		head = head.next;
		tail = tail.next;
	    }
	    head.next = bar;
	    head = head.next;
	}
	return result;
    }

}

