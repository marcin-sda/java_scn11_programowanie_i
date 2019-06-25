package com.sda.structures.queue;

public interface QueueOfIntegers {

    /**
     * EN: Enqueues data.
     * PL: Zakolejkowuje dane.
     *
     * @param data to be enqueued (dane do zakolejkowania)
     */
    void enqueue(Integer data);

    /**
     * EN: Dequeues data.
     * PL: Usuwa element z kolejki.
     */
    void dequeue();

    /**
     * EN: Peeks first element of the queue.
     * PL: Podgląda pierwszy element w kolejce.
     *
     * @return first element of the queue (pierwszy element z kolejki)
     */
    Integer peek();

    /**
     * EN: Checks if queue is empty.
     * PL: Sprawdza czy kolejka jest pusta.
     *
     * @return true if empty (prawda jeśli pusta)
     */
    boolean isEmpty();
}
