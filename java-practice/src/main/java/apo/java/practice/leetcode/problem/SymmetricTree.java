package apo.java.practice.leetcode.problem;


public class SymmetricTree {
    public static void main(String[] args) {
        var root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val == root2.val) {
            return (isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));
        }
        return false;
    }


}
