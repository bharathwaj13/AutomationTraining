package org.onboard.java8.lambdaexpressions;

import java.util.Collections;
import java.util.List;

public class SecondBiggestNumber {

    /*public static int secondBiggest(List<Integer> list) {
        Collections.sort(list);
        return list.get(list.size() - 2);
    }*/

    //Using Lambda
    public static int secondBiggest(List<Integer> list) {
        Integer number = list.stream().sorted((a,b)->b-a).skip(1).findFirst().get();
        return number;

    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 4, 45, 99);
        System.out.println(secondBiggest(numbers));
    }
}
