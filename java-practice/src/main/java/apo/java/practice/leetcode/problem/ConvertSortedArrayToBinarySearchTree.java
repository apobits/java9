package apo.java.practice.leetcode.problem;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        var numbers = new int[]{0, 1, 2, 3, 4, 5};
//        var others = new int[]{-10, -3, 0, 5, 9};
        var root = sortedArrayToBST(numbers);
    }

    public static TreeNode sortedArrayToBST(int[] numbers) {
        return addNode(numbers, 0, numbers.length - 1);
    }

    private static TreeNode addNode(int[] numbers, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }
        int half = (leftIndex + rightIndex) / 2;
        var root = new TreeNode(numbers[half]);
        root.left = addNode(numbers, leftIndex, half - 1);
        root.right = addNode(numbers, half + 1, rightIndex);
        return root;
    }
}
