package com.sda.algorithms.sort;

public class BubbleSort implements Sort {
    @Override
    public Integer[] sort(Integer[] values) {
        int tmp;
        boolean swap = false;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j + 1] < values[j]) {
                    tmp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = tmp;
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
        return values;
    }
}
