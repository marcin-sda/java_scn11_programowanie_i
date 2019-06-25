package com.sda.search;

import com.sda.structures.array.ArraySearchImpl;
import org.junit.Assert;
import org.junit.Test;

public class SearchTest {

    @Test
    public void testFindHighest() {
        Integer[] integers = { 20, 10, 30, 12, 14 };
        ArraySearchImpl<Integer> searcher = new ArraySearchImpl<>();
        Assert.assertEquals(Integer.valueOf(30), searcher.findHighest(integers));
    }
}
