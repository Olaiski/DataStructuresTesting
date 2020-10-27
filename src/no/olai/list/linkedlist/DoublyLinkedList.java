package no.olai.list.linkedlist;

import no.olai.list.MyList;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements MyList<E> {

    private Node<E> head, tail;
    private int size = 0;


    public DoublyLinkedList() {
    }

    public DoublyLinkedList(E[] objects) {
        for (E object : objects) add(object);
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);

        if (head == null) {
            newNode.next = null;
            newNode.previous = null;
            head = tail = newNode;

        }
        else {
            head.previous = newNode;
            newNode.next = head;
            newNode.previous = null;
            head = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (tail == null) {
            newNode.next = null;
            newNode.previous = null;
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.next = null;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean add(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node<E> newNode = new Node<>(e);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> current = head;

            for(int i = 1; i < index; i++)
                current = current.next;

            newNode.next = current.next;
            current.next = newNode;
            newNode.previous = current;
            (newNode.next).previous = newNode;
        }
        size++;
    }

    public E removeLast() {
        if (size == 0) return null;
        else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else {
            Node<E> temp = tail;
            tail = tail.previous;
            tail.next = null;
            size--;

            return temp.element;
        }
    }

    public E removeFirst() {

        if (size == 0) return null;
        else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else {
            Node<E> temp = head;
            head = head.next;
            head.previous = null;
            size--;

            return temp.element;
        }

    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return head.element;
        else if (index == size - 1) return tail.element;
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;

            return current.next.element;
        }
    }

    @Override
    public int indexOf(Object e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++){
            if (e.equals(current.element)) return i;
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
                    break;
                }
            }
            return e;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<E> current = head;

            for (int i = 1; i < index; i++) {
                current = current.next;
                (current.previous).next = current.next;
                (current.next).previous = current.previous;
            }
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
        for (int i = 0; i < size; i++) {
            if(e.equals(current.element)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
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

        DoublyLinkedList.Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current == null) break;

            sb.append(current.element);
            current = current.next;
            sb.append((current != null) ? ", " : "]");
        }

        return sb.toString();
    }

    public String toStringReverse() {

        return "";
    }

    // TODO: 05/10/2020 Trenger litt pussing. 
    public class DoublyLinkedListIterator implements ListIterator<E> {

        private Node<E> current = head;
        private Node<E> lastAccessed = null;
        private int index = 0;

        public DoublyLinkedListIterator() {
        }

        @Override
        public boolean hasNext() { return index < size; }

        @Override
        public boolean hasPrevious() { return index > size; }

        @Override
        public int previousIndex() { return index - 1; }

        @Override
        public int nextIndex() { return index; }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessed = current;
            E e = current.element;
            current = current.next;
            index++;
            return e;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.previous;
            index--;
            lastAccessed = current;
            return current.element;
        }

        @Override
        public void set(E e) {
            if (lastAccessed == null) throw new IllegalStateException();
            lastAccessed.element = e;
        }

        @Override
        public void remove() {
            if (lastAccessed == null) throw new IllegalStateException();
            Node<E> x = lastAccessed.previous;
            Node<E> y = lastAccessed.next;
            x.next = y;
            y.previous = x;
            size--;

            if (current == lastAccessed)
                current = y;
            else
                index--;
            lastAccessed = null;

        }

        @Override
        public void add(E e) {
            Node<E> x = current.previous;
            Node<E> y = new Node<>();
            Node<E> z = current;
            y.element = e;
            y.next = z;
            z.previous = y;
            y.previous = x;
            size++;
            index++;
            lastAccessed = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (DoublyLinkedListIterator it = this; it.hasNext(); ) {
                E e = it.next();
                sb.append(e).append(" ");
            }
            return sb.toString();
        }
    }

    private static class Node<E> {
        private E element;
        private Node<E> next, previous;

        public Node() {
        }

        public Node(E element) {
            this.element = element;
        }
    }
}
