package apo.java.practice.leetcode.problem;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            var tempHead = head;
            while (tempHead.next != null) {
                if (tempHead.val == tempHead.next.val) {
                    tempHead.next = tempHead.next.next;
                } else {
                    tempHead = tempHead.next;
                }
            }
        }
        return head;
    }
}
