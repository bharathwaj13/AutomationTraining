package org.onboard.corejava.langconstructs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given three ints, a b c, return true if b is greater than a, and c is greater than b.
 * However, with the exception that if "bOk" is true, b does not need to be greater than a.
 * <p>
 * inOrder(1, 2, 4, false) ? true
 * inOrder(1, 2, 1, false) ? false
 * inOrder(1, 1, 2, true) ? true
 * Test your logic at :http://codingbat.com/prob/p154188
 */

public class Task5 {
    @Test
    public void example1() {
        Assert.assertEquals(true, inOrder(1, 2, 4, false));
    }

    @Test
    public void example2() {
        Assert.assertEquals(false, inOrder(1, 2, 1, false));
    }

    @Test
    public void example3() {
        Assert.assertEquals(true, inOrder(1, 1, 2, true));
    }

    private boolean inOrder(int a, int b, int c, boolean bOk) {

        if (!bOk) {
            if (b > a && c > b) return true;
        } else if (bOk) {
            if (c > b) return true;
        } else return false;

        return false;
    }
}



