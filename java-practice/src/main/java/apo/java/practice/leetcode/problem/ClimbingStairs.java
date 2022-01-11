package apo.java.practice.leetcode.problem;

public class ClimbingStairs {
    public static int climbStairs(int n){
        int r = 1, prev = 0;
        for (int i = 0; i < n ; i++) {
            int temp = r;
            r += prev;
            prev = temp;
        }
        return r;
    }
}
