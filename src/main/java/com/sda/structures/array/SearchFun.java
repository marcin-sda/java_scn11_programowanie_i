package com.sda.structures.array;

import java.util.Random;

public class SearchFun {
    /**
     * Generuje losowe wartości i umieszcza je w tablicy przekazanej do funkcji
     */
    public static void generateIntegers(Integer[] integers, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(maxValue);
        }
    }

    /**
     * Znajduje największą liczbę w tablicy przekazanej do funkcji
     */
    public static Integer findHighest(Integer[] integers) {
        Integer highest = 0;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] > highest) {
                highest = integers[i];
            }
        }
        return highest;
    }

    /**
     * Oblicza średnią arytmetyczną dla liczb przekazanych do funkcji.
     */
    public static Double findAverage(Integer[] integers) {
        Double sum = 0.0;
        for (int i = 0; i < integers.length; i++) {
            sum += integers[i];
        }
        return sum / integers.length;
    }

    /**
     * Tablica 'integers' zawiera M liczb ze zbioru [1, N].
     * Funkcja wypisuje wszystkie liczby ze zbioru [1, N], ktore nie wystepuja w
     * przekazanej do funkcji tablicy.
     */
    public static void findMissing(Integer[] integers, int N) {
        int[] counter = new int[N];
        for (int i = 0; i < integers.length; i++) {
            counter[integers[i]-1] += 1;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) {
                System.out.println("Missing number: " + String.valueOf(i+1));
            }
        }
    }
}
