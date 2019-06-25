package com.sda.structures.stack;

/**
 * EN: Generic stack interface.
 * PL: Generyczny interfejs stosu.
 *
 * @param <T> is type of data to be keep on stack (T określa typ danych przechowywanych na stosie)
 */
public interface Stack<T> {

    /**
     * EN: Pushes data to the stack.
     * PL: Wstawia dane na stos.
     *
     * @param data to be pushed (dane do wstawienia)
     */
    void push(T data);

    /**
     * EN: Pops data from the stack.
     * PL: Zdejmuje dane ze stosu.
     *
     * @return data (dane)
     */
    T pop();

    /**
     * EN: Checks if stack is empty.
     * PL: Sprawdza czy stos jest pusty.
     *
     * @return true if empty (prawda jeśli pusty)
     */
    boolean isEmpty();

    /**
     * EN: Peeks top item from the stack.
     * PL: Podgląda element na górze stosu.
     *
     * @return top element (górny element)
     */
    T peek();
}
