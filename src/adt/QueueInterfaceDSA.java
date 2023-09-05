/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author Claude
 */
public interface QueueInterfaceDSA<T> {
    
    public Iterator<T> getIterator();

    public void enqueue(T newEntry);

    public T dequeue();

    public T getFront();

    public T getEntry(T obj);

    public T getEntry(int position);

    public boolean isEmpty();

    public void clear();

    public int getNumberOfEntries();
}
