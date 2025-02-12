package org.onboard.java8.lambdaexpressions;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetSortReverse {

    public static void main(String[] args) {
        /*Set<Integer> treeSet=new TreeSet<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });*/

        //Using Lambda

        Set<Integer> treeSet = new TreeSet<>((o1,o2)-> o2-o1);
        treeSet.add(10);
        treeSet.add(30);
        treeSet.add(20);
        System.out.println(treeSet);
    }
}
