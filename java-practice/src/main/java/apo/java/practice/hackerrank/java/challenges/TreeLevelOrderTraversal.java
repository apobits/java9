package apo.java.practice.hackerrank.java.challenges;

import java.util.*;

public class TreeLevelOrderTraversal {

    private static int counter = -1;

    public static void main(String[] args) {
	var node = new Node(1, null, new Node(2, null, new Node(5, new Node(3, null, new Node(4, null, null)), new Node(6, null, null))));
	levelOrder(node);
    }

    public static void levelOrder(Node root) {
	Map<Integer, List<Integer>> map = new TreeMap<>();
	levelOrderHelper(root, map);
	for (Integer key : map.keySet()) {
	    for (Integer n : map.get(key)) {
		System.out.print(n + " ");
	    }
	}
    }

    private static void levelOrderHelper(Node root, Map<Integer, List<Integer>> map) {
	if (root == null) {
	    return;
	}
	counter++;
	map.merge(counter, new ArrayList<>(Arrays.asList(root.data)), (t, u) -> {
	    t.addAll(u);
	    return t;
	});
	levelOrderHelper(root.left, map);
	levelOrderHelper(root.right, map);
	counter--;
    }
}
