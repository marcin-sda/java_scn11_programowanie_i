package com.sda.structures.stack;

/**
 * EN: Stack of Integer objects.
 * PL: Stos obiektów typu Integer.
 */
public interface StackOfIntegers {
    /**
     * EN: Pushes data to the stack.
     * PL: Wstawia dane na stos.
     *
     * @param data to be pushed (dane do wstawienia)
     */
    void push(Integer data);

    /**
     * EN: Pops data from the stack.
     * PL: Zdejmuje dane ze stosu.
     *
     * @return data (dane)
     */
    Integer pop();

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
    Integer peek();
}
