package org.onboard.corejava.langconstructs;


import org.junit.Assert;
import org.junit.Test;

/**
 * You have a blue lottery ticket, with ints a, b, and c on it. This makes three pairs, which we'll call ab, bc, and ac. Consider the sum of the numbers in each pair. If any pair sums to exactly 10, the result is 10. Otherwise if the ab sum is exactly 10 more than either bc or ac sums, the result is 5. Otherwise the result is 0.
 * <p>
 * Test your logic at :http://codingbat.com/prob/p192267
 */

public class Task4 {

    @Test
    public void example1() {
        Assert.assertEquals(10, blueTicket(9, 1, 0));
    }

    @Test
    public void example2() {
        Assert.assertEquals(0, blueTicket(9, 2, 0));
    }

    @Test
    public void example3() {
        Assert.assertEquals(10, blueTicket(6, 1, 4));
    }

    @Test
    public void example4() {
        Assert.assertEquals(5, blueTicket(12, 4, 2));
    }

    private int blueTicket(int a, int b, int c) {
        int ab = a + b, bc = b + c, ac = a + c;
        if (ab == 10 || bc == 10 || ac == 10) return 10;
        else if (ab == bc + 10 || ab == ac + 10) return 5;
        else return 0;
    }
}
