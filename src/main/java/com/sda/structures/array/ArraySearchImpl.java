package com.sda.structures.array;

public class ArraySearchImpl <T extends Number & Comparable<T>> implements ArraySearch<T> {

    public T findHighest(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        T currentMax = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(currentMax) > 0) {
                currentMax = array[i];
            }
        }
        return currentMax;
    }

    public T findLowest(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        T currentMin = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(currentMin) < 0) {
                currentMin = array[i];
            }
        }
        return currentMin;
    }

    public Double findAverage(T[] array)
    {
        Double sum = 0.0;
        for (T item : array) {
            sum += item.doubleValue();
        }
        return sum / array.length;
    }
}
