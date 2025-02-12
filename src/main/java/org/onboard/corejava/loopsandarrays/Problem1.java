package org.onboard.corejava.loopsandarrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Consider the leftmost and righmost appearances of some value in an array.
 * We'll say that the "span" is the number of elements between the two inclusive.
 * A single value has a span of 1. Returns the largest span found in the given array.
 * (Efficiency is not a priority.)
 * <p>
 * <p>
 * maxSpan([1, 2, 1, 1, 3]) → 4
 * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
 * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
 *
 * Test your code at : http://codingbat.com/prob/p189576
 */

public class Problem1 {

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 1, 3};
        Assert.assertEquals(4, maxSpan(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 2, 1, 4, 1, 4};
        Assert.assertEquals(6, maxSpan(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 4, 2, 1, 4, 4, 4};
        Assert.assertEquals(6, maxSpan(nums));
    }

    private int maxSpan(int[] nums) {
        if(nums.length==0) return 0;
        int span = 0, maxSpan = 0;
        boolean bFlag = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                bFlag = true;
                span = Math.abs(map.get(nums[i]) - i) + 1;
                maxSpan = Math.max(span, maxSpan);
            } else map.put(nums[i], i);
        }
        if (!bFlag) return 1;
        else return maxSpan;
    }
}
