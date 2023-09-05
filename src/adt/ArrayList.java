/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Claude
 */
public class ArrayList<T> implements ListInterface<T>, Serializable, Iterable<T> {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 8;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Object[initialCapacity];
    }

    //CORE OPERATIONS (appear in list ADT specification & the interface ListInterface)
    @Override
    public boolean add(T newEntry) throws IllegalArgumentException {
        //check if newEntry is null
        if (newEntry == null) {
            throw new IllegalArgumentException("Cannot add a null entry.");
        }

        //if array is full, increase array size
        if (isArrayFull()) {
            doubleArray();
        }
        //insert the new entry into array
        array[numberOfEntries] = newEntry;
        //move pointer to next index, (next space)
        numberOfEntries++;
        return true;
    }

    //position starts from 1, index from 0
    @Override
    public boolean add(int newPosition, T newEntry) {
        //default add is successful
        boolean isSuccessful = true;

        //if position for insertion of newEntry is within range 
        //range follows after elemets hv been shifted
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            //shift elements ahead to make space for newEntry
            makeRoom(newPosition);
            array[newPosition - 1] = newEntry;
            numberOfEntries++;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        //check if array is empty before removing
        if (array != null) {
            //if position is within range, assign element at that array index to result.
            if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
                result = array[givenPosition - 1];

                //if position is less than array size
                if (givenPosition < numberOfEntries) {
                    removeGap(givenPosition);
                }

                numberOfEntries--;
            }
        }

        return result;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean replace(int index, T newEntry) {
        boolean isSuccessful = true;
//
//        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
//            array[givenPosition - 1] = newEntry;
//        } else {
//            isSuccessful = false;
//        }

        //check if index is valid
        if ((index < 1) || (index > numberOfEntries)) {
            return false;
        }

        //replace the element at index with newEntry
        array[index - 1] = newEntry;
        isSuccessful = true;

        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];
        }

        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        //return false becoz array will keep on expanding.
        return false;
    }

    //sort element in specific order based on this comparison logic
    public void bubbleSort(ListInterface<T> list, Comparator<T> comparator) {

        //keep track whether arrayList sorted after each pass thru loop
        boolean sortedArrList;

        //keep track of number of passes through the loop.
        //in each pass, check if adjacent elements & swap of they are in wrong order
        //used to reduce no. of comparison in subsequent pass 
        //(largest element = guaranteeed at end of list)
        int pass = 0;

        //loop until whole sortedArrList sorted (become true)
        do {
            sortedArrList = true;

            //iterate through arrayList Elements 
            /* -pass means after each pass, the largest element is in the correct 
             position (end of list), so no need to compare agn*/
            for (int i = 0; i < numberOfEntries - 1 - pass; i++) {

                //compare 2 adjacent element using comparator
                // > 0 means element are out of order (need to swap)
                if (comparator.compare(array[i], array[i + 1]) > 0) {

                    //swap position. Move larger element to end
                    swapPosition(i, i + 1);

                    //indicate ArrayList might not be fully sorted
                    sortedArrList = false;
                }
            }
            //reduce no of comparision
            pass++;

            //loop till sortedArrList become true 
            //when no swap occured & list fully sorted
        } while (!sortedArrList);
    }

    private void swapPosition(int n1, int n2) {
        T temp = array[n1];
        array[n1] = array[n2];
        array[n2] = temp;
    }

   
    @Override
    public void mergeSort(Comparator<T> comparator) {
        int length = size();

        if (length < 2) {
            return; // Base case: a list of 0 or 1 elements is already sorted.
        }

        // Split the list into two halves.
        int mid = length / 2;
        ListInterface<T> leftList = new ArrayList<>();
        ListInterface<T> rightList = new ArrayList<>();

        for (int i = 1; i <= mid; i++) {
            leftList.add(getEntry(i));
        }

        for (int i = mid + 1; i <= length; i++) {
            rightList.add(getEntry(i));
        }

        // Recursively bubbleSort the two halves.
        leftList.mergeSort(comparator);
        rightList.mergeSort(comparator);

        // Merge the sorted halves back into the original list.
        merge(leftList, rightList, comparator);
    }

    private void merge(ListInterface<T> leftList, ListInterface<T> rightList, Comparator<T> comparator) {
        int leftLength = leftList.size();
        int rightLength = rightList.size();
        int i = 1, j = 1, k = 1;

        while (i <= leftLength && j <= rightLength) {
            if (comparator.compare(leftList.getEntry(i), rightList.getEntry(j)) <= 0) {
                replace(k, leftList.getEntry(i));
                i++;
            } else {
                replace(k, rightList.getEntry(j));
                j++;
            }
            k++;
        }

        // Copy any remaining elements from leftList and rightList (if any).
        while (i <= leftLength) {
            replace(k, leftList.getEntry(i));
            i++;
            k++;
        }
        while (j <= rightLength) {
            replace(k, rightList.getEntry(j));
            j++;
            k++;
        }
    }

//    @Override
//    public ListInterface<T> subList(int fromIndex, int toIndex) {
//        if (fromIndex < 1 || fromIndex > toIndex || toIndex > numberOfEntries) {
//            throw new IllegalArgumentException("Invalid sublist indices");
//        }
//
//        ListInterface<T> sublist = new ArrayList<>();
//
//        for (int i = fromIndex; i <= toIndex; i++) {
//            sublist.add(array[i - 1]);
//        }
//
//        return sublist;
//    }
    private boolean isArrayFull() {
        return numberOfEntries == array.length;
    }

    private void doubleArray() {
        T[] oldArray = array;
        array = (T[]) new Object[2 * oldArray.length];
        //for loop
        for (int index = 0; index < array.length; index++) {
            array[index] = oldArray[index];
        }
    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += array[index] + "\n";
        }

        return outputStr;
    }

    //UTILITY OPERATIONS (support core operations), implemented as private
    /**
     * Task: Makes room for a new entry at newPosition. Precondition: 1 <=
     * newPosition <= numberOfEntries + 1; numberOfEntries is array's
     * numberOfEntries before addition.
     */
    //shifts elements ahead
    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        // move each entry to next higher index, starting at end of
        // array and continuing until the entry at newIndex is moved
        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    /**
     * Task: Shifts entries that are beyond the entry to be removed to the next
     * lower position. Precondition: array is not empty; 1 <= givenPosition <
     * numberOfEntries; numberOfEntries is array's numberOfEntries before
     * removal.
     */
    private void removeGap(int givenPosition) {
        // move each entry to next lower position starting at entry after the
        // one removed and continuing until end of array
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator(this);
    }

    //Iterator Class
    class ArrayListIterator<T> implements Iterator<T> {

        private final ArrayList<T> list;
        private int currentPosition = 0;

        public ArrayListIterator(ArrayList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < list.numberOfEntries;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T currentItem = list.array[currentPosition];
                currentPosition++;
                return currentItem;
            } else {
                throw new NoSuchElementException("ArrayLst does not contain anymore element");
            }
        }

    }

}
