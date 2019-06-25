package com.sda.algorithms.fib;

import java.util.ArrayList;

public class FibonacciSequence {

    public static void fiboRecursive(ArrayList<Integer> fibos, int len) {
        if (len == 1) {
            fibos.add(0);
            fibos.add(1);
            return;
        }
        fiboRecursive(fibos, len - 1);
        fibos.add(fibos.get(len - 1) + fibos.get(len - 2));
    }
}
