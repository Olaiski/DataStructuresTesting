package no.olai.stacksqueue.ringbuffer;

public interface MyQueue<E> {

    boolean offer(E e);

    E peek();

    E poll();

    int size();

    boolean isEmpty();

}
