package com.sda.structures.queue;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class QueueTest {

    private static final int QUEUE_SIZE = 10;
    private Queue<Integer> mQueue;

    @Before
    public void setupQueue() {
        mQueue = new QueueImpl<>(QUEUE_SIZE);
    }

    @Test
    public void someTest() {
        Integer value = -1;
        QueueOfIntegers queue = new QueueIntImpl(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        value = queue.peek();
        queue.dequeue();
        value = queue.peek();
        queue.dequeue();
        value = queue.peek();
        assertTrue(queue.isEmpty());
        queue.enqueue(99);
    }

    @Test
    public void testNewQueueIsEmpty() {
        QueueOfIntegers queue = new QueueIntImpl(10);
        assertNotNull(queue);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueIsNotEmptyAfterEnqueue() {
        assertTrue(mQueue.isEmpty());
        mQueue.enqueue(10);
        assertFalse(mQueue.isEmpty());
    }

    @Test
    public void testWhenEnqueueFirstValueItCanBePeeked() {
        final int value = 15;
        assertTrue(mQueue.isEmpty());
        mQueue.enqueue(value);
        assertEquals(value, mQueue.peek().intValue());
    }

    @Test
    public void testWhenEnqueueAndDequeuePeekReturnsProperValue() {
        assertTrue(mQueue.isEmpty());
        int valCount = 6;
        enqueueN(mQueue, valCount, 10);
        dequeueN(mQueue, valCount - 1);
        assertEquals(15, mQueue.peek().intValue());
    }

    @Test
    public void testWhenEnqueueAndDequeuePeekReturnsProperValue_2() {
        assertTrue(mQueue.isEmpty());
        enqueueN(mQueue, 7, 10);
        assertEquals(10, mQueue.peek().intValue());
        dequeueN(mQueue, 3);
        assertEquals(13, mQueue.peek().intValue());
        enqueueN(mQueue, 5, 20);
        assertEquals(13, mQueue.peek().intValue());
        dequeueN(mQueue, 4);
        assertEquals(20, mQueue.peek().intValue());
        enqueueN(mQueue, 4, 30);
        assertEquals(20, mQueue.peek().intValue());
        dequeueN(mQueue,5);
        assertEquals(30, mQueue.peek().intValue());
    }

    private void enqueueN(Queue<Integer> queue, int n, int offset) {
        for (int i = 0; i < n; i++) {
            queue.enqueue(i+offset);
        }
    }

    private void dequeueN(Queue<Integer> queue, int n) {
        for (int i = 0; i < n; i++) {
            queue.dequeue();
        }
    }
}
