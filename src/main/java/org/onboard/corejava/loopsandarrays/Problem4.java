package org.onboard.corejava.loopsandarrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the array,
 * the same group appears in reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1}
 * is length 3 (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
 * <p>
 * maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) â†’ 3
 * maxMirror([1, 2, 1, 4]) â†’ 3
 * maxMirror([7, 1, 2, 9, 7, 2, 1]) â†’ 2
 * <p>
 * Test your code at : http://codingbat.com/prob/p196409
 */
public class Problem4 {

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 8, 9, 3, 2, 1};
        Assert.assertEquals(3, maxMirror(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 4};
        Assert.assertEquals(3, maxMirror(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7, 1, 2, 9, 7, 2, 1};
        Assert.assertEquals(2, maxMirror(nums));
    }

    @Test
    public void example4() {
        int[] nums = {1, 2, 1, 20, 21, 1, 2, 1, 2, 23, 24, 2, 1, 2, 1, 25};
        Assert.assertEquals(4, maxMirror(nums));
    }

    private int maxMirror(int[] nums) {
        if(nums.length==0) return 0;
        String input = Arrays.stream(nums)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());

        String temp = "";
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                temp = nums[j] + temp;
                if (input.contains(temp)) max = Math.max(max, j-i+1);
                else break;
            }
            temp="";
        }

        return max;

    }


}
