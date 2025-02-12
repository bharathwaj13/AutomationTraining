package org.onboard.java8.lambdaexpressions;

import java.util.Map;
import java.util.TreeMap;

public class ReverseTreeMap {
    public static void main(String[] args) {
        /*Map<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });*/

        //Using Lambda
        Map<Integer,String> map=new TreeMap<>((o1, o2) -> o2-o1);

        map.put(1, "One");
        map.put(3, "Three");
        map.put(2, "Two");
        System.out.println(map);
    }
}
