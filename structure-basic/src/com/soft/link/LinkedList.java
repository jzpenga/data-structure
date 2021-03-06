package com.soft.link;

import java.util.IllegalFormatCodePointException;
import java.util.zip.CRC32;

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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size=0;
    }

    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //Node node = new Node(e);
        //node.next = prev.next;
        //prev.next = node;

        prev.next = new Node(e,prev.next);

        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

   public E get(int index){
       if(index < 0 || index > size){
           throw new IllegalArgumentException("Add failed. Illegal index.");
       }
       Node cur = dummyHead;
       for (int i = 0; i < index; i++) {
           cur = cur.next;
       }
       return cur.e;
   }

   public E getLast(){
        return get(size);
   }

   public E getFirst(){
        return get(0);
   }

   public void set(int index,E e){
       if(index < 0 || index > size){
           throw new IllegalArgumentException("Add failed. Illegal index.");
       }
       Node cur = dummyHead;
       for (int i = 0; i < index; i++) {
           cur = cur.next;
       }
       cur.e = e;
   }


   public E remove(int index){
       if(index < 0 || index > size){
           throw new IllegalArgumentException("Add failed. Illegal index.");
       }
       Node prev = dummyHead;
       for (int i = 0; i < index; i++) {
           prev = prev.next;
       }
       Node delNode = prev.next;
       prev.next = delNode.next;
       delNode.next = null;
       size--;
       return delNode.e;
   }

   public E removeFirst(){
        return remove(0);
   }

   public E removeLast(){
        return remove(size-1);
   }

   public boolean contains(E e){
        Node cur = dummyHead;
        while (cur!=null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
   }



    public boolean isEmpty(){
        return size==0;
    }

    public int getSize(){
        return size;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
            res.append(cur).append("->");
        res.append("NULL");

        return res.toString();
    }

}
