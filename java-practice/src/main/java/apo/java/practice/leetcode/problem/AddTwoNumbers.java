package apo.java.practice.leetcode.problem;

public class AddTwoNumbers {
    public static void main(String[] args) {
	var l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
	var l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
	var r = addTwoNumbers(l1, l2);
	while (r != null) {
	    System.out.print(r.val);
	    r = r.next;
	}
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	var linkedListResult = new ListNode();
	var linkedListResultHeader = linkedListResult;
	int carry = 0;
	while (l1 != null || l2 != null) {
	    int left = l1 == null ? 0 : l1.val;
	    int right = l2 == null ? 0 : l2.val;
	    int tempResult = left + right + carry;
	    if (tempResult > 9) {
		linkedListResult.val = tempResult % 10;
		carry = tempResult / 10;
	    } else {
		linkedListResult.val = tempResult;
		carry = 0;
	    }
	    l1 = l1 == null ? null : l1.next;
	    l2 = l2 == null ? null : l2.next;
	    if (l1 != null || l2 != null) {
		linkedListResult.next = new ListNode();
		linkedListResult = linkedListResult.next;
	    }
	}

	if (carry > 0) {
	    linkedListResult.next = new ListNode(carry);
	}

	return linkedListResultHeader;
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
