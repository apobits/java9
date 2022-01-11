package apo.java.practice.leetcode.problem;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 4));
    }

    public static int searchInsert(int[] nums, int target) {
        var insertionIndex = new InsertionIndex();
        var result = searchInsertHelper(nums, target, 0, nums.length - 1, insertionIndex);
        return result != -1 ? result : insertionIndex.index + 1;
    }

    private static int searchInsertHelper(int[] nums, int target, int left, int right, InsertionIndex insertionIndex) {
        if (left < right && nums[left] < target && nums[right] > target) {
            int mid = (right + left) / 2;
            int l = searchInsertHelper(nums, target, left, mid, insertionIndex);
            if (l != -1) {
                return l;
            }
            int r = searchInsertHelper(nums, target, mid + 1, right, insertionIndex);
            if (r != -1) {
                return r;
            }
        }

        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target) {
                insertionIndex.index = i;
            }
        }

        return -1;

    }
}

class InsertionIndex {
    protected int index = -1;
}
// [0,1,2,3,4,5,6,7,8,9]