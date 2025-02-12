package org.onboard.java8.lambdaexpressions;

import java.util.function.BiPredicate;

public class StringRotations {

    /*public static boolean areRotations(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return (str1 + str1).contains(str2);
    }*/

    //Using Lambda
    public static boolean areRotations(String str1, String str2) {
        BiPredicate<String, String> biPredicate=(s1,s2) -> s1.length()==s2.length() && (s1+s1).contains(s2);
        return biPredicate.test(str1,str2);
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "deabc";
        System.out.println(areRotations(str1, str2));
    }
}
