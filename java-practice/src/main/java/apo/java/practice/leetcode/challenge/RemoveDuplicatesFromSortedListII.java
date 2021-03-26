package apo.java.practice.leetcode.challenge;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
	var list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
	var list2 = new ListNode(1, new ListNode(1, new ListNode(2)));
	var list3 = new ListNode(1, new ListNode(1));
	var list4 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2))));
	var result = deleteDuplicates(list4);
    }

    public static ListNode deleteDuplicates(ListNode head) {
	if (head == null) {
	    return null;
	}
	var prev = head;
	var start = head.val;
	var result = head;
	while (head != null && head.next != null) {
	    if (head.val == head.next.val) {
		var next = findNextDifferentValue(head.next);
		if (head.val == start) {
		    head = next;
		    if (head == null) {
			return null;
		    }
		    result = head;
		    start = head.val;
		} else {
		    prev.next = next;
		    head = prev;
		}
	    } else {
		prev = head;
		head = head.next;
	    }
	}
	return result;
    }

    private static ListNode findNextDifferentValue(ListNode listNode) {
	var val = listNode.val;
	while (listNode.next != null && listNode.next.val == val) {
	    listNode = listNode.next;
	}
	return listNode.next;
    }
}
