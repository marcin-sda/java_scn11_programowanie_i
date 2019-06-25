package com.sda.structures.queue;

public class QueueImpl <T> implements Queue<T> {

    T[] mTab;
    int mStart = 0;
    int mEnd = 0;

    public QueueImpl(int size) {
        mTab = (T[]) new Object[size];
    }

    public int length() {
        return mStart < mEnd ? mEnd - mStart : mTab.length - (mTab.length - mEnd + mStart);
    }

    /**
     * EN: Enqueues data.
     * PL: Zakolejkowuje dane.
     *
     * @param data to be enqueued (dane do zakolejkowania)
     */
    @Override
    public void enqueue(T data) {

    }

    /**
     * EN: Dequeues data.
     * PL: Usuwa element z kolejki.
     */
    @Override
    public void dequeue() {

    }

    /**
     * EN: Peeks first element of the queue.
     * PL: Podgląda pierwszy element w kolejce.
     *
     * @return first element of the queue (pierwszy element z kolejki)
     */
    @Override
    public T peek() {
        return mTab[mEnd];
    }

    /**
     * EN: Checks if queue is empty.
     * PL: Sprawdza czy kolejka jest pusta.
     *
     * @return true if empty (prawda jeśli pusta)
     */
    @Override
    public boolean isEmpty() {
        return length() == 0;
    }
}
