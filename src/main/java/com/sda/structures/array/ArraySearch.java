package com.sda.structures.array;

public interface ArraySearch <T  extends Number & Comparable<T>> {
    T findHighest(T[] array);
    T findLowest(T[] array);
    Double findAverage(T[] array);
}
