package org.onboard.corejava.langconstructs;

import org.junit.Assert;
import org.junit.Test;

/**
 * The number 6 is a truly great number. Given two int values, a and b, return true if either one is 6.
 * Or if their sum or difference is  6. Note: the function Math.abs(num) computes the absolute value of a number.
 */

public class Task2 {

    @Test
    public void example1() {
        Assert.assertEquals(true, checkGreatNumber(60, 6));
    }

    @Test
    public void example2() {
        Assert.assertEquals(true, checkGreatNumber(4, 2));
    }

    @Test
    public void example3() {
        Assert.assertEquals(false, checkGreatNumber(56, 66));
    }

    private boolean checkGreatNumber(int num1, int num2) {
        if(num1==6 || num2==6 || num1+num2==6 || Math.abs(num1-num2)==6) return true;
        else return false;
    }


}
