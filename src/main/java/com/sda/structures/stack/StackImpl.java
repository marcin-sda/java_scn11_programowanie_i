package com.sda.structures.stack;

public class StackImpl<T> implements  Stack<T> {

    private T[] mData;
    int mFree = 0;

    public StackImpl(int size) {
        mData = (T[]) new Object[10];
    }

    public int getCapacity() {
        return mData.length;
    }

    @Override
    public void push(T data) {
        if (mFree >= getCapacity()) {
            //throw new RuntimeException("stack overflow");
            return;
        }
        mData[mFree] = data;
        mFree++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        mFree--;
        return mData[mFree];
    }

    @Override
    public boolean isEmpty() {
        return mFree == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return mData[mFree-1];
    }
}
