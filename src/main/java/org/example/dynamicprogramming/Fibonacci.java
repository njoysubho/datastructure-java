package org.example.dynamicprogramming;

import java.math.BigInteger;
import java.util.function.Function;

public class Fibonacci{

    public static long recursiveFib(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

    public static BigInteger recursiveFibTwoVars(int n){
        BigInteger back0 = BigInteger.ZERO;
        BigInteger back1 = BigInteger.ONE;
        if (n == 0) return BigInteger.ZERO;
        for (int i = 2; i < n; i++) {
            BigInteger next = back0.add(back1);
            back0 = back1;
            back1 = next;
        }
        return back0.add(back1);
    }

    public static BigInteger recursiveFibDynamic(int n){
        BigInteger[] fib = new BigInteger[n + 1];
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        return fib[n];
    }

    public static void main(String[] args){
        System.out.println("Running recusriveFib");
      //  runner(Fibonacci::recursiveFib, 100);
        System.out.println("Running recursiveFibTwoVars");
        runner(Fibonacci::recursiveFibTwoVars, 2000);
        System.out.println("Running recursiveFibDynamic");
        runner(Fibonacci::recursiveFibDynamic, 2000);
    }

    public static void runner(Function<Integer, BigInteger> action, int num){
        long start = System.currentTimeMillis();
        System.out.println("result = " + action.apply(num));
        System.out.println("time = " + (System.currentTimeMillis() - start) + "ms");
    }
}
