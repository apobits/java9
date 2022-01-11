package apo.java.practice.leetcode.problem;

public class DesignHashSet {
    public static void main(String[] args) {

    }

    private boolean[] buckets = new boolean[1000001];

    public void add(int v) {
        buckets[v] = true;
    }

    public void remove(int v) {
        buckets[v] = false;
    }

    public boolean contains(int v) {
        return buckets[v];
    }
}
