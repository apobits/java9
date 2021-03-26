package apo.java.practice.hackerrank.java.challenges;

public class TreeHeightOfABinaryTree {
    private static int height;
    private static int counter;

    public static int height(Node root) {
	getHeight(root);
	return height;
    }

    private static void getHeight(Node root) {
	if (root == null) {
	    height = Math.max(height, counter);
	    return;
	}
	counter++;
	getHeight(root.left);
	getHeight(root.right);
	counter--;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
	this.data = data;
	this.left = left;
	this.right = right;
    }
}
