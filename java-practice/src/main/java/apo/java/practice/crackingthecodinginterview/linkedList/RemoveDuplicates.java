package apo.java.practice.crackingthecodinginterview.linkedList;

import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
	var node = new Node(1, new Node(2, new Node(3, new Node(2, new Node(4, new Node(5, null))))));
	removeDuplicates(node);
	while (node != null) {
	    System.out.print(node.data + " ");
	    node = node.next;
	}
    }

    public static void removeDuplicates(Node head) {
	var hashSet = new HashSet<Integer>();
	hashSet.add(head.data);
	var headCopy = head;
	while (headCopy.next != null) {
	    if (!hashSet.add(headCopy.next.data)) {
		headCopy.next = headCopy.next.next;
	    }
	    headCopy = headCopy.next;
	}
    }
}
