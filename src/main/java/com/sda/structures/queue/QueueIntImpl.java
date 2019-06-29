package com.sda.structures.queue;

public class QueueIntImpl implements QueueOfIntegers{

    Integer[] mTab;
    int mStart = 0;
    int mEnd = 0;

    public QueueIntImpl(int size) {
        mTab = new Integer[size];
    }

    public int length() {
        return mStart <= mEnd ? mEnd - mStart : mStart - mEnd;
    }

    /**
     * EN: Enqueues data.
     * PL: Zakolejkowuje dane.
     *
     * @param data to be enqueued (dane do zakolejkowania)
     */
    @Override
    public void enqueue(Integer data) {
        if (length() == mTab.length) {
            return;
        }
        if (mEnd == mTab.length) {
            mEnd = 0;
        }
        mTab[mEnd] = data;
        mEnd++;
    }

    /**
     * EN: Dequeues data.
     * PL: Usuwa element z kolejki.
     */
    @Override
    public void dequeue() {
        if (length() != 0) {
            mStart++;
        }
        if (mStart == mTab.length) {
            mStart = 0;
            if (mEnd == mTab.length) {
                mEnd = 0;
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
    public Integer peek() {
        return new Integer(mTab[mStart]);
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
