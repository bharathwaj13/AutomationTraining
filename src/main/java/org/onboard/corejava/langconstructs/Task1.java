package org.onboard.corejava.langconstructs;

import org.junit.Assert;
import org.junit.Test;

/**
 * You are driving a little too fast, and a police officer stops you. Write code to compute the result,
 * encoded as an int value: 0=no ticket, 1=small ticket, 2=big ticket. If speed is 60 or less,
 * the result is 0. If speed is between 61 and 80 inclusive, the result is 1.
 * If speed is 81 or more, the result is 2. Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.
 * <p>
 * Test your logic at :http://codingbat.com/prob/p157733
 */

public class Task1 {

    @Test
    public void example1() {
        Assert.assertEquals(0, caughtSpeeding(60, false));
    }

    @Test
    public void example2() {
        Assert.assertEquals(1, caughtSpeeding(65, false));
    }

    @Test
    public void example3() {
        Assert.assertEquals(0, caughtSpeeding(65, true));
    }

    private int caughtSpeeding(int speed, boolean isBirthday) {
        if (isBirthday) speed -= 5;
        if (speed <= 60) return 0;
        else if (speed > 60 && speed <= 80) return 1;
        else return 2;
    }
}
