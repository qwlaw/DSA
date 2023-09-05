/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author Claude
 */
public class ArrayQueueDSA<T> implements QueueInterfaceDSA<T>, Serializable{
    
    private final static int firstIndex = 0;
    private int lastIndex = 0;
    private T[] Qarray;
    private int numberOfEntries;
    private static final int defaultCapacity = 50;

    public ArrayQueueDSA() {
        this(defaultCapacity);
    }

    public ArrayQueueDSA(int initialCap) {
        Qarray = (T[]) new Object[initialCap];
        lastIndex = -1;
    }

    public void enqueue(T newEntry) {
        if (!isArrayFull()) {
            lastIndex++;
            Qarray[lastIndex] = newEntry;
        }
        numberOfEntries++;

    }

    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = Qarray[firstIndex];
        }
        return front;
    }

    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = Qarray[firstIndex];
            for (int i = firstIndex; i < lastIndex; ++i) {
                Qarray[i] = Qarray[i + 1];
            }
            lastIndex--;
        }
        numberOfEntries--;
        return front;
    }

    public boolean isEmpty() {
        return firstIndex > lastIndex;
    }

    public void clear() {
        if (!isEmpty()) { // deallocates only the used portion      
            for (int index = firstIndex; index <= lastIndex; index++) {
                Qarray[index] = null;
            }
            lastIndex = -1;
        }
    }

    private boolean isArrayFull() {
        return lastIndex == Qarray.length - 1;
    }

    public Iterator<T> getIterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<T> {

        private int nextIndex;

        private ArrayQueueIterator() {
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex <= lastIndex;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T nextEntry = Qarray[nextIndex];
                nextIndex++;
                return nextEntry;
            } else {
                return null;
            }
        }
    }

    @Override
    public T getEntry(T obj) {
        T result = null;
        int i = 0;
        for (i = 0; i < numberOfEntries; i++) {
            if (Qarray[i].equals(obj)) {
                result = Qarray[i];
                break;
            }
        }

        return result;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = Qarray[givenPosition - 1];
        }

        return result;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public String toString() {
        String output = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            output += Qarray[index] + "\n";
        }
        return output;
    }
}
