package apo.java.practice.leetcode.problem;

import org.junit.Assert;

public final class MaximumSubarray {
    public static void main(String[] args) {
        Assert.assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(-1, maxSubArray(new int[]{-1}));
        Assert.assertEquals(-1, maxSubArray(new int[]{-2, -1}));
        Assert.assertEquals(1, maxSubArray(new int[]{-2, 1}));
        Assert.assertEquals(7, maxSubArray(new int[]{-2,3,1,3}));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0], current = nums[0], index = 0;
        while (++index < nums.length) {
            if (current + nums[index] > nums[index]) {
                current += nums[index];
            } else {
                current = nums[index];
            }
            if (max < current) {
                max = current;
            }
        }
        return Math.max(max, current);
    }
}
