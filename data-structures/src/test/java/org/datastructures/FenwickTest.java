package org.datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class FenwickTest {

    @Test
    public void correctnessTest() {
        int n = 100;
        Fenwick tree = new Fenwick(n);
        int[] mas = new int[n];
        int probes = 1000;
        Random rn = new Random();
        for (int i = 0; i < probes; i++) {
            int pos = rn.nextInt(n);
            int val = rn.nextInt(2 * n) - n;
            tree.inc(pos, val);
            mas[pos] += val;
            int left = rn.nextInt(n);
            int right = rn.nextInt(n);
            if (left > right) {
                int buf = left;
                left = right;
                right = buf;
            }
            int correct = 0;
            for (int j = left; j <= right; j++) {
                correct += mas[j];
            }
            Assert.assertEquals(correct, tree.sum(left, right));
        }
    }
}
