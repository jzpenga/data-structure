package com.soft.array;

public class Array<E> {
    private E[] data;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (E[]) new Object[10];
    }

    public void add(int index, E e) {

        checkIndex(index);

        if (data.length==size){
            resize(size*2);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index){
        checkIndex(index);
        E e = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        size--;
        if (size<data.length/4){
            resize(data.length/2);
        }
        return e;
    }

    public E removeElement(E e){
        int index = find(e);
        if (index>=0){
            return remove(index);
        }
        return null;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    private int find(E e){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                index = i;
            }
        }
        return index;
    }

    public void set(int index,E e){
        checkIndex(index);
        data[index] = e;
    }

    public E get(int index){
        checkIndex(index);
        return data[index];
    }

    public E getLast(){
        return data[size-1];
    }

    public E getFirst(){
        return data[0];
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    private void checkIndex(int index){
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int getSize() {
        return size;
    }


    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
