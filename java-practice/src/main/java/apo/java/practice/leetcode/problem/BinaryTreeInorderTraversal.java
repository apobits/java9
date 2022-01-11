package apo.java.practice.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        var node = new TreeNode(5, new TreeNode(3, new TreeNode(1, null, null), new TreeNode(4, null, new TreeNode(2, null, null))), new TreeNode(6, null, null));
        System.out.println(inorderTraversal(node));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();
        traverseInorder(root, list);
        return list;
    }

    private static void traverseInorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverseInorder(root.left, list);
        list.add(root.val);
        traverseInorder(root.right, list);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}