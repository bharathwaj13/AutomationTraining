package org.onboard.corejava.langconstructs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given 2 non-negative ints, a and b, return their sum, so long as the sum has the same number of digits
 * as a. If the sum has more digits than a, just return a without b.
 * (Note: one way to compute the number of digits of a non-negative int n is to convert
 * it to a string with String.valueOf(n) and then check the length of the string.)
 * <p>
 * sumLimit(2, 3) ? 5
 * sumLimit(8, 3) ? 8
 * sumLimit(8, 1) ? 9
 * Test your logic at :http://codingbat.com/prob/p118077
 */

public class Task7 {

    @Test
    public void example1() {
        Assert.assertEquals(5, sumLimit(2, 3));
    }

    @Test
    public void example2() {
        Assert.assertEquals(8, sumLimit(8, 3));
    }

    @Test
    public void example3() {
        Assert.assertEquals(9, sumLimit(8, 1));
    }

    private int sumLimit(int a, int b) {
        int sum = a + b;
        if (String.valueOf(sum).length() == String.valueOf(a).length()) return sum;
        else return a;
    }
}
