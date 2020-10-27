package no.olai.stacksqueue;

import java.util.ArrayList;


public class GenericStack<E> {
    private ArrayList<E> list = new ArrayList<>();


    public void push(E e) {
        list.add(e);
    }

    public E pop() {
        return list.remove(list.size()-1);
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return "Stack: " + list.toString();
    }
}
