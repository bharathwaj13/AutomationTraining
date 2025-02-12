package org.onboard.corejava.langconstructs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.
 * <p>
 * maxBlock("hoopla") ? 2
 * maxBlock("abbCCCddBBBxx") ? 3
 * maxBlock("") ? 0
 * Test your logic at : http://codingbat.com/prob/p179479
 */

public class Task9 {

    @Test
    public void example1() {
        Assert.assertEquals(2, maxBlock("hoopla"));
    }

    @Test
    public void example2() {
        Assert.assertEquals(3, maxBlock("abbCCCddBBBxx"));
    }

    @Test
    public void example3() {
        Assert.assertEquals(0, maxBlock(""));
    }

    private int maxBlock(String str) {
        if (str.isEmpty()) return 0;
        else if (str.length() == 1) return 1;
        int left = 0, right = 0, maxLength = 0;
        while (right < str.length()) {
            if (str.charAt(left) == str.charAt(right)) {
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else left = right;
        }
        return maxLength;
    }
}
