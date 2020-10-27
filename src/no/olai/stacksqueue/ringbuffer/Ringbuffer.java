package no.olai.stacksqueue.ringbuffer;

import java.util.Arrays;

public class Ringbuffer<E> implements MyQueue<E> {

    private E[] objects;
    private int writeSequence = -1;
    private int readSequence = 0;
    private int capacity;
    private int size;

    public Ringbuffer(int capacity) {
        this.capacity = capacity;
        this.objects = (E[]) new Object[capacity];
    }

    // Inserts an element into the buffer at the next available slot and return true on success.
    @Override
    public boolean offer(E e) {
        boolean isFull = (writeSequence - readSequence) + 1 == capacity;

        if (!isFull) {
            int nextWriteSeq = writeSequence + 1;
            objects[nextWriteSeq % capacity] = e;
            writeSequence++;
            size++;
            return true;
        }

        return false;
    }

    @Override
    public E poll() {
        if (!isEmpty()) {
            E nextValue = objects[readSequence % capacity];
            readSequence++;
            size--;
            return nextValue;
        }
        return null;
    }

    @Override
    public E peek() {
        return objects[writeSequence - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return writeSequence < readSequence;
    }



    @Override
    public String toString() {
        return "Ringbuffer: " + Arrays.toString(objects);
    }
}
