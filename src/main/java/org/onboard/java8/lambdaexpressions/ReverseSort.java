package org.onboard.java8.lambdaexpressions;

import java.util.Arrays;
import java.util.List;

public class ReverseSort {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 2, 4, 5);
        /*Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });*/

        //Using Lambda
        numbers.sort(((o1, o2) -> o2-o1));

        System.out.println(numbers);
    }
}
