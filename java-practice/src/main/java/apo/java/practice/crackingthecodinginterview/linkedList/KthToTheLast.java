package apo.java.practice.crackingthecodinginterview.linkedList;

public class KthToTheLast {
    private static int index = 0;
    private static Node node = null;

    public static void main(String[] args) {
	var head = new Node(1, new Node(2, new Node(3, new Node(2, new Node(4, new Node(5, null))))));
	kthToLast(head, 2);
	System.out.println(node.data);

    }

    public static void kthToLast(Node head, int kth) {
	if (head == null) {
	    return;
	}
	kthToLast(head.next, kth);
	if (++index == kth) {
	    node = head;
	}
    }

}
