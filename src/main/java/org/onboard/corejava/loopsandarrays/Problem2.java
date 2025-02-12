package org.onboard.corejava.loopsandarrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
 * <p>
 * canBalance([1, 1, 1, 2, 1]) â†’ true
 * canBalance([2, 1, 1, 2, 1]) â†’ false
 * canBalance([10, 10]) â†’ true
 * <p>
 * Test your code at :http://codingbat.com/prob/p158767
 */
public class Problem2 {

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 2, 1};
        Assert.assertTrue(canBalance(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 1, 2, 1};
        Assert.assertFalse(canBalance(nums));
    }

    @Test
    public void example3() {
        int[] nums = {10, 10};
        Assert.assertTrue(canBalance(nums));
    }


    private boolean canBalance(int[] nums) {
        if (nums.length < 2) return false;
        int leftSum = 0, rightSum = 0;
        int totalSum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            rightSum = totalSum - leftSum;
            if (leftSum == rightSum) return true;
        }
        return false;
    }


}
