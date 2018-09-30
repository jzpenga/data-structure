package com.soft.link;

import com.soft.queue.Queue;

import java.util.PrimitiveIterator;

public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> data = new LinkedList<>();
    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
