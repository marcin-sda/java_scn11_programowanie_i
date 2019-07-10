package com.sda.structures.queue;

public class QueueImpl <T> implements Queue<T> {

    T[] mTab;
    int mStart = 0;
    int mEnd = -1;
    private int mCounter = 0;

    public QueueImpl(int size) {
        mTab = (T[]) new Object[size];
    }

    public int length() {
        return mCounter;
    }

    /**
     * EN: Enqueues data.
     * PL: Zakolejkowuje dane.
     *
     * @param data to be enqueued (dane do zakolejkowania)
     */
    @Override
    public void enqueue(T data) {
        if (length() == mTab.length) {
            return;
        }
        mEnd++;
        mCounter++;
        if (mEnd == mTab.length) {
            mEnd = 0;
        }
        mTab[mEnd] = data;
    }

    /**
     * EN: Dequeues data.
     * PL: Usuwa element z kolejki.
     */
    @Override
    public void dequeue() {
        if (length() > 0) {
            mStart++;
            mCounter--;
        }
        if (mStart == mTab.length) {
            mStart = 0;
            if (mEnd == mTab.length) {
                mEnd = -1;
            }
        }
    }

    /**
     * EN: Peeks first element of the queue.
     * PL: Podgląda pierwszy element w kolejce.
     *
     * @return first element of the queue (pierwszy element z kolejki)
     */
    @Override
    public T peek() {
        return mTab[mStart];
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
