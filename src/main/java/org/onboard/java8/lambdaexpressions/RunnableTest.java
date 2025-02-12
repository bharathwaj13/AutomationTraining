package org.onboard.java8.lambdaexpressions;

public class RunnableTest {

    public static void main(String[] args) {
        /*Runnable test = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        };
        new Thread(test).run();*/

        //Using Lambda

        Runnable test=()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };
        new Thread(test).run();
    }
}
