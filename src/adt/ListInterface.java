/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

import java.util.Comparator;

/**
 *
 * @author Claude
 */
//identifier T = represents data type within class definition.
//It also represents data type of entries in the list. 
//It will be defined as generic type within the class
//when using the class, supply type argument to replace 'T'
//A generic type must be a reference type, not primitive
public interface ListInterface<T> {

 
    public boolean add(T newEntry);

    public boolean add(int newPosition, T newEntry);

    public T remove(int givenPosition);

    public void clear();

    public boolean replace(int index, T newEntry);

    public T getEntry(int givenPosition);

    public boolean contains(T anEntry);

    public int getNumberOfEntries();

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    /**
     *
     * @param list
     * @param comparator
     */
    public void bubbleSort(ListInterface<T> list, Comparator<T> comparator);
    
    //public void mergeSort(ListInterface<T> list, Comparator<T> comparator);
    
    public void mergeSort(Comparator<T> comparator);

    
    //public ListInterface<T> subList(int fromIndex, int toIndex) ;

}
