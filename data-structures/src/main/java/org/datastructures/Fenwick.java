package org.datastructures;

public class Fenwick {

    private int n;
    private int[] tree;

    public Fenwick(int n) {
        this.n = n;
        tree = new int[n];
    }

    public void inc(int pos, int val) {
        for (int i = pos; i < n; i = (i | (i + 1))) {
            tree[i] += val;
        }
    }

    public int sum(int right) {
        int result = 0;
        for (int i = right; i >= 0; i = (i & (i + 1)) - 1) {
            result += tree[i];
        }
        return result;
    }

    public int sum(int left, int right) {
        if (left <= 0) {
            return sum(right);
        }
        return sum(right) - sum(left - 1);
    }
}
