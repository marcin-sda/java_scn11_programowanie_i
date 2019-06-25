package com.sda.structures.stack;

public class StackOfIntegersImpl implements StackOfIntegers {
    private Integer[] mData;
    int mFree = 0;

    public StackOfIntegersImpl(int size) {
        mData = new Integer[10];
    }

    public int getCapacity() {
        return mData.length;
    }

    @Override
    public void push(Integer data) {
        if (mFree >= getCapacity()) {
            //throw new RuntimeException("stack overflow");
            return;
        }
        mData[mFree] = data;
        mFree++;
    }

    @Override
    public Integer pop() {
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
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return mData[mFree-1];
    }
}

