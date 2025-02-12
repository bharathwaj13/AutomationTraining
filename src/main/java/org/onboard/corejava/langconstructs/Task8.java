package org.onboard.corejava.langconstructs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given two strings, base and remove, return a version of the base string where all instances of
 * the remove string have been removed (not case sensitive). You may assume that the remove string
 * is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
 * <p>
 * withoutString("Hello there", "llo") ? "He there"
 * withoutString("Hello there", "e") ? "Hllo thr"
 * withoutString("Hello there", "x") ? "Hello there"
 * Test your logic at : http://codingbat.com/prob/p192570
 */

public class Task8 {

    @Test
    public void example1() {
        Assert.assertEquals("He there", withoutString("Hello there", "llo"));
    }

    @Test
    public void example2() {
        Assert.assertEquals("Hllo thr", withoutString("Hello there", "e"));
    }

    @Test
    public void example3() {
        Assert.assertEquals("Hello there", withoutString("Hello there", "x"));
    }

    @Test
    public void example4() {
        Assert.assertEquals("Th  a FH", withoutString("This is a FISH", "IS"));
    }

    private String withoutString(String base, String remove) {
        StringBuilder temp = new StringBuilder(base);
        while ((base.toLowerCase().contains(remove.toLowerCase()))) {
            int index = base.toLowerCase().indexOf(remove.toLowerCase());
            temp.delete(index, index + remove.length());
            base=base.toLowerCase().replaceFirst(remove.toLowerCase(), "");
        }
        return temp.toString();
    }
}
