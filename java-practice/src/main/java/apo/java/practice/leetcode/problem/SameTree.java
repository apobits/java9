package apo.java.practice.leetcode.problem;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class SameTree {

    public static void main(String[] args) {
        var node1 = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(1, null, null));
        var node2 = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(1, null, null));
        Assert.assertTrue(isSameTree(node1, node2));
    }

    public static boolean isSameTree(TreeNode node1, TreeNode node2) {
        var list1 = new ArrayList<TreeNode>();
        traverseInOrder(node1, list1);
        var list2 = new ArrayList<TreeNode>();
        traverseInOrder(node2, list2);
        return equals(list1, list2);
    }

    private static void traverseInOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.left, list);
        traverseInOrder(node.right, list);
        list.add(node);
    }

    private static boolean equals(List<TreeNode> list1, List<TreeNode> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            var node1 = list1.get(i);
            var node2 = list2.get(i);
            if (node1.val != node2.val || (node1.left == null && node2.left != null) || (node1.left != null && node2.left == null) || (node1.right == null && node2.right != null) || (node1.right != null && node2.right == null)) {
                return false;
            }
        }
        return true;
    }

}
