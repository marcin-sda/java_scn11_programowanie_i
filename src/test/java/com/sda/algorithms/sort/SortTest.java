package com.sda.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SortTest {

    Sort sortAlgo;

    @Before
    public void setup() {
        sortAlgo = new BubbleSort();
    }

    @Test
    public void testRandomDataIsSorted() {
        ArrayList<Integer> data = getRandomValues(15);
        Integer[] intArray = new Integer[data.size()];
        data.toArray(intArray);
        System.out.println("original: " + data.toString());
        System.out.println("sorted:   " + Arrays.toString(sortAlgo.sort(intArray)));
        for (int i = 0; i < intArray.length - 1; i++) {
            if (intArray[i] > intArray[i+1]) {
                assertFalse(true);
            }
        }
    }

    private ArrayList<Integer> getRandomValues(int amount) {
        Random random = new Random();
        ArrayList<Integer> values = new ArrayList<>();
        while (amount > 0) {
            values.add(random.nextInt(256));
            amount--;
        }
        return values;

    }
}
