package com.dataStructures.array;

import java.util.Iterator;

public class Array <T> implements Iterable <T> {
    private T [] arr;
    private int capacity;
    private int len;

    public Array(){
        this(16);
    }
    public Array(int capacity){
        if (capacity < 0 )
            throw new IllegalArgumentException("Illegal Capacity : " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int index){
        return arr[index];
    }

    public void set(int index, T element){
        arr[index] = element;
    }

    public void clear(){
        for(int i=0;i<capacity;i++)
            arr[i] = null;
        len = 0;
    }

    public void add (T elem){
        if (len + 1 >= capacity) {
            if (capacity == 0) { capacity = 1; }
            else { capacity = capacity * 2; }
            T[] arr2 = (T[]) new Object[capacity * 2];
            for (int i=0; i <= len ; i++){
                arr2[i] = arr[i];
            }
            arr=arr2;
        }
        arr[len++] = elem;
    }

    public T removeAt(int index){
        T data = arr[index];
        if ( index >= capacity | index < 0) { throw new ArrayIndexOutOfBoundsException("illegal index: " + index ); }
        for (int i = index ; i < len ; i++ ){
            arr[i]= arr[i+1];
        }
        arr[len] = null;
        len--;
        return data;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < len; i++) {
            if(arr[i].equals(obj))
                removeAt(i);
                return true;
        }
        return false;
    }

    public int indexOf(Object obj){
        for (int i = 0; i < len; i++) {
            if(arr[i].equals(obj))
                return i;
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }
}
