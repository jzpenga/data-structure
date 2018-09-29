package com.soft.link;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHeader;
    private int size;

    public LinkedList(){
        dummyHeader = null;
        size=0;
    }

    public void add(E e){

    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getSize(){
        return size;
    }


}
