package org.onboard.corejava.langconstructs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given two ints, each in the range 10..99, return true if there is a digit that appears in both numbers,
 * such as the 2 in 12 and 23. (Note: division, e.g. n/10, gives the left digit while the % "mod" n%10 gives the right digit.)
 * <p>
 * shareDigit(12, 23) ? true
 * shareDigit(12, 43) ? false
 * shareDigit(12, 44) ? false
 * Test your logic at : http://codingbat.com/prob/p153748
 */

public class Task6 {

    @Test
    public void example1() {
        Assert.assertEquals(true, shareDigit(12, 23));
    }

    @Test
    public void example2() {
        Assert.assertEquals(false, shareDigit(12, 43));
    }

    @Test
    public void example3() {
        Assert.assertEquals(false, shareDigit(12, 44));
    }

    private boolean shareDigit(int a, int b) {
        if (Integer.toString(b).contains(a / 10 + "") || Integer.toString(b).contains(a % 10 + "")) return true;
        else return false;
    }

}
