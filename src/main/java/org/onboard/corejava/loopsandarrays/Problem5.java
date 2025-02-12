package org.onboard.corejava.loopsandarrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer. The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order.
 * <p>
 * linearIn([1, 2, 4, 6], [2, 4]) â†’ true
 * linearIn([1, 2, 4, 6], [2, 3, 4]) â†’ false
 * linearIn([1, 2, 4, 4, 6], [2, 4]) â†’ true
 * <p>
 * Test your code at :http://codingbat.com/prob/p134022
 */
public class Problem5 {

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 4, 6};
        int[] nums2 = {2, 4};
        Assert.assertEquals(true, linearIn(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2, 4, 6};
        int[] nums2 = {2, 3, 4};
        Assert.assertEquals(false, linearIn(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 2, 4, 4, 6};
        int[] nums2 = {2, 4};
        Assert.assertEquals(true, linearIn(nums1, nums2));
    }

    private boolean linearIn(int[] outer, int[] inner) {
        int leftIndex = 0, rightIndex = 0;
        while (leftIndex < outer.length && rightIndex < inner.length) {
            if (inner[rightIndex] > outer[leftIndex]) leftIndex++;
            else if (inner[rightIndex] < outer[leftIndex]) return false;
            else {
                rightIndex++;
                leftIndex++;
            }
        }
        if (inner.length == rightIndex) return true;
        else return false;
    }
}
