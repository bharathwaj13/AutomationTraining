package org.onboard.corejava.loopsandarrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. Return the number of clumps in the given array.
 * <p>
 * countClumps([1, 2, 2, 3, 4, 4]) â†’ 2
 * countClumps([1, 1, 2, 1, 1]) â†’ 2
 * countClumps([1, 1, 1, 1, 1]) â†’ 1
 * <p>
 * Test your code at : http://codingbat.com/prob/p193817
 */

public class Problem3 {

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3, 4, 4};
        Assert.assertEquals(2, countClamps(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 2, 1, 1};
        Assert.assertEquals(2, countClamps(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 1, 1};
        Assert.assertEquals(1, countClamps(nums));
    }

    private int countClamps(int[] nums) {
        int count = 0;
        int i = 0;

        while(i < nums.length) {
            int val = nums[i];
            i++;
            int length = 1;
            while(i < nums.length && nums[i] == val) {
                i++;
                length++;
            }

            if(length > 1)
                count++;
        }

        return count;
    }
}
