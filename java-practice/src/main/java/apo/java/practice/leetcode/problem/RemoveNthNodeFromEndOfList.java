package apo.java.practice.leetcode.problem;

import java.util.ArrayList;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        var list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        var list1 = new ListNode(1);
        var result = removeNthFromEnd(list1, 1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode root, int index) {
        var list = new ArrayList<ListNode>();
        var temp = root;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        int listIndex = list.size() - index;
        var next = listIndex + 1 < list.size() ? list.get(listIndex + 1) : null;
        if (listIndex == 0) {
            root = next;
        } else {
            list.get(listIndex - 1).next = next;
        }
        return root;
    }
}
