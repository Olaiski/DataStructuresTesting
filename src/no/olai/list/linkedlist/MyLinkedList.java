package no.olai.list.linkedlist;

import no.olai.list.MyList;

import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {

    private Node<E> head, tail;
    private int size = 0;


    public MyLinkedList() {
    }

    public MyLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    public E getFirst() {
        if (size == 0) {
            return null;
        }
        else  {
            return head.element;
        }
    }

    public E getLast() {
        if (size == 0) {
            return null;
        }
        else {
            return tail.element;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null)
            tail = head;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (tail == null) { // If list empty -> both head and tail will point to this new node
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return temp.element;
        }
    }

    public E removeLast() {
        if (size <= 1) return removeFirst();
        else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++)
                current = current.next;

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++)
                previous = previous.next;

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return head.element;
        else if (index == size - 1) return tail.element;
        else {
            Node<E> current = head;

            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            return current.next.element;
        }

    }


    @Override
    public int indexOf(Object e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (e.equals(current.element)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> current = head;
        int count = 0;
        int lastIndex = 0;
        boolean found = false;

        while (current != null) {
            if (e.equals(current.element)) {
                lastIndex = count;
                found = true;
            }
            count++;
            current = current.next;
        }
        return found ? lastIndex : -1;
    }

    @Override
    public E set(int index, E e) {
        Node<E> current = head;

        if (index < 0 || index >= size) return null;
        else if (index == 0) {
            head.element = e;
            return e;
        }
        else if (index == size - 1) {
            tail.element = e;
            return e;
        }
        else {
            for (int i = 1; i < size - 1; i++) {
                if (index == i) {
                    current.next.element = e;
                }
                current = current.next;
            }
        }
        return e;
    }


    @Override
    public boolean contains(Object e) {
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            if (e.equals(current.element)) return true;
            current = current.next;
        }
        return false;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            sb.append(current.element);
            current = current.next;
            sb.append((current != null) ? ", " : "]");
        }

        return sb.toString();
    }



    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;


        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override // FIXME: 29/09/2020 Ikke helt ok?
        public void remove() {
            E e = current.element;
            MyLinkedList.this.remove(e);
        }


    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E e) {
            element = e;
        }
    }

    @Override
    public int size() {
        return size;
    }
}


