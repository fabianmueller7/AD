package e4.performanceComparison;

import e4.performanceComparison.stack.CStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.UUID;

public class Stacktester {

    public static void main(String[] args) {
        System.out.println("Stack Tester");

        final int test1 = 100000;
        System.out.println("test1: " + test1);
        System.out.println("My implementation: " + Stacktester.testMyImplementation(test1,5) + "ms");
        System.out.println("Java Stack: " + Stacktester.testJavaStack(test1,5) + "ms");
        System.out.println("Java Deque: " + Stacktester.testJavaDeque(test1,5) + "ms");

        final int test2 = 1000000;
        System.out.println("test2: " + test2);
        System.out.println("My implementation: " + Stacktester.testMyImplementation(test2,5) + "ms");
        System.out.println("Java Stack: " + Stacktester.testJavaStack(test2,5) + "ms");
        System.out.println("Java Deque: " + Stacktester.testJavaDeque(test2,5) + "ms");

        final int test3 = 10000000;
        System.out.println("test2: " + test3);
        System.out.println("My implementation: " + Stacktester.testMyImplementation(test3,5) + "ms");
        System.out.println("Java Stack: " + Stacktester.testJavaStack(test3,5) + "ms");
        System.out.println("Java Deque: " + Stacktester.testJavaDeque(test3,5) + "ms");



    }

    public static long testMyImplementation(final int numberOfElements, final int stringLength) {

        //setup
        CStack stack = new CStack(numberOfElements);
        final long starttime = System.nanoTime();

        //act
        for (int i = 0; i < numberOfElements; i++) {
            stack.push(Stacktester.getRandomString(stringLength));
        }

        //terminate
        final long endtime = System.nanoTime();

        return (endtime-starttime)/1000000L;
    }

    //result in miliseconds
    public static long testJavaStack(final int numberOfElements, final int stringLength) {

        //setup
        Stack stack = new Stack();
        stack.setSize(numberOfElements);
        final long starttime = System.nanoTime();

        //act
        for (int i = 0; i < numberOfElements; i++) {
            stack.push(Stacktester.getRandomString(stringLength));
        }

        //terminate
        final long endtime = System.nanoTime();

        return (endtime-starttime)/1000000L;
    }

    //result in miliseconds
    public static long testJavaDeque(final int numberOfElements, final int stringLength) {

        //setup
        Deque<String> deque = new ArrayDeque<>();
        final long starttime = System.nanoTime();

        //act
        for (int i = 0; i < numberOfElements; i++) {
            deque.offerLast(Stacktester.getRandomString(stringLength));
        }

        //terminate
        final long endtime = System.nanoTime();

        return (endtime-starttime)/1000000L;
    }



    public static String getRandomString(int length)
    {
        String randomStr = UUID.randomUUID().toString();
        while(randomStr.length() < length) {
            randomStr += UUID.randomUUID().toString();
        }
        return randomStr.substring(0, length);
    }
}
