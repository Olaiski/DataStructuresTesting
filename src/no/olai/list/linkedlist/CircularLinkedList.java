package no.olai.list.linkedlist;

import no.olai.list.MyList;

import java.util.Iterator;

public class CircularLinkedList<E> implements MyList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public CircularLinkedList() {
    }

    public CircularLinkedList(E[] objects) {
        for (E object : objects) add(object);
    }

    public E getFirst() {
        return size == 0 ? null : head.element;
    }

    public E getLast() {
        if (size == 0) return null;
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

    @Override
    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);

        if (head == null)
            head = newNode;
        else
            tail.next = newNode;

        tail = newNode;
        tail.next = head;
        size++;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int lastIndexOf(E e) {
        return 0;
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    public E removeFirst() {
        if (size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            tail.next = head;
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
            tail.next = head;
            size--;
            return temp.element;
        }
    }

    @Override
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
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object e) {
        Node<E> current = head;
        if (head == null) return false;
        else {
            for (int i = 0; i < size; i++) {
                current = current.next;
                if (e.equals(current.element)) return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        if (head == null && tail == null) sb = new StringBuilder("[]");

        CircularLinkedList.Node<E> current = head;
        for (int i = 0; i < size; i++) {
            sb.append(current.element);
            current = current.next;
            sb.append((current != head) ? ", " : "]");
        }

        return sb.toString();
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E e) {
            this.element = e;
        }
    }

    public int getSize() {
        return size;
    }
}
