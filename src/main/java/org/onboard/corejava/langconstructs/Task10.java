package org.onboard.corejava.langconstructs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, return the sum of the numbers appearing in the string, ignoring all other characters.
 * A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char
 * is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
 * <p>
 * sumNumbers("abc123xyz") ? 123
 * sumNumbers("aa11b33") ? 44
 * sumNumbers("7 11") ? 18
 * Test your logic at : http://codingbat.com/prob/p121193
 */

public class Task10 {
    @Test
    public void example1() {
        Assert.assertEquals(123, sumNumbers("abc123xyz"));
    }

    @Test
    public void example2() {
        Assert.assertEquals(44, sumNumbers("aa11b33"));
    }

    @Test
    public void example3() {
        Assert.assertEquals(18, sumNumbers("7 11"));
    }

    private int sumNumbers(String str) {
        int right = 0;
        String temp = "";
        List<Integer> list = new ArrayList<>();
        while (right < str.length()) {
            if (Character.isDigit(str.charAt(right))) temp = temp + str.charAt(right);
            else {
                if (!temp.isEmpty()) list.add(Integer.parseInt(temp));
                temp = "";
            }
            right++;
        }
        if (!temp.isEmpty()) list.add(Integer.parseInt(temp));
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
        return list.stream().reduce(0, Integer::sum);
    }
}
