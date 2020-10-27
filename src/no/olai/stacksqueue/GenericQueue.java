package no.olai.stacksqueue;

import java.util.LinkedList;

public class GenericQueue<E> {
    // GenericQueue uses a linked list to provide a first-in, first-out data structure
    private LinkedList<E> list = new LinkedList<>();

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public int getSize() {
        return list.size();
    }


    @Override
    public String toString() {
        return "Queue: " + list.toString();
    }
}
