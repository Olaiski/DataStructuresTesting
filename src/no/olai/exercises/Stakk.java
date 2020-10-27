package no.olai.exercises;

public interface Stakk<E> {

    void push(E e);

    E pop();

    E peek();

}
