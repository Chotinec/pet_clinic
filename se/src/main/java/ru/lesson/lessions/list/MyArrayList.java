package ru.lesson.lessions.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by art on 17.05.16.
 */
public class MyArrayList<E> implements Iterable<E>  {

    /* Const default size of array*/
    private final int DEFAULT_SIZE = 10;

    /* Array inside MyArrayList*/
    private Object[] array = new Object[DEFAULT_SIZE];

    /* Actual count of array*/
    private int actualSize = 0;

    /**
     * size of arrayList
     * @return int size
     */
    public int size(){
        return actualSize;
    }

    /**
     * Add new item to the array
     * @param data new item
     * @return true if operation success
     */
    public boolean add(E data){
        if (actualSize >= array.length/2){
            increaseSize();
        }
        array[actualSize++] = data;
        return true;
    }

    /**
     * Add new item to the array in the position number i
     * @param data new item
     * @param i position number
     * @return true if operation success
     */
    public boolean add(int i ,E data){
        if (i >= actualSize){
            throw new IndexOutOfBoundsException();
        }

        System.arraycopy(array, i, array, i + 1, actualSize - i);
        array[i] = data;
        actualSize++;
        return true;
    }

    /**
     * Remove item from the list
     * @param data to remove
     * @return tru if remove item successfully
     */
    public E remove(E data){
        int index = findIndexInArray(data);
        if (index == -1)
            return null;
        E oldValue = (E)array[index];
        System.arraycopy(array, index+1, array, index, actualSize - index - 1);
        array[--actualSize] = null;

        return oldValue;
    }

    /**
     * Checking for the presence item in the list
     * @param data to checking
     * @return
     */
    public boolean contains(E data){
        for (int i = 0; i < array.length; i++){
            if (array[i] == null){
                continue;
            }
            if (array[i].equals(data))
                return true;
        }

        return false;
    }

    /**
     * Check if collection is empty
     * @return true if emty, false if no
     */
    public boolean isEmpty(){
        return actualSize == 0;
    }

    /**
     * get array item
     * @param i number in the array
     * @return array item
     */
    public E get(int i){
        if (i >= actualSize){
            throw new IndexOutOfBoundsException();
        }
        return (E)array[i];
    }

    /**
     * Reset list
     */
    public void clear(){
        actualSize = 0;
    }

    /**
     * Copy our list to array
     * @param newArray array to copy
     */
    public void coppyTo(E[] newArray){
        newArray = (E[]) Arrays.copyOf(array, array.length);
    }

    /**
     * Resize array
     * @throws RuntimeException
     */
    private void increaseSize()throws RuntimeException{
        array = Arrays.copyOf(array,(array.length*3)/2 + 1);
    }

    /**
     * Find index in Array
     * @param data for search
     * @return -1 if not found else position number
     */
    private int findIndexInArray(E data){
        for (int i = 0; i < array.length; i++){
            if (array[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Create iterator
     * @return iterator
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int index;

            @Override
            public boolean hasNext() {
                return index < actualSize;
            }

            @Override
            public E next() {
                if (index >= actualSize)
                    throw new NoSuchElementException();
                return (E)array[index++];
            }

            @Override
            public void remove() {
                System.arraycopy(array, index+1, array, index, actualSize - index - 1);
                array[--actualSize] = null;
            }
        };
    }
}
