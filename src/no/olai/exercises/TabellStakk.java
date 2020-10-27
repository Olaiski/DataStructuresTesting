package no.olai.exercises;

import java.util.Arrays;

public class TabellStakk<E> implements Stakk<E> {


    private E[] tabell;
    private int antall;
    final static int STARTKAPASITET = 2;


    public TabellStakk() {
        this(STARTKAPASITET);
    }

    public TabellStakk(int kapasitet) {
        if (kapasitet < STARTKAPASITET) utvidTabell();

        tabell = (E[]) new Object[kapasitet];
        antall = 0;
    }

    private void utvidTabell() {
        if (antall >= tabell.length) {
            E[] newData = (E[]) new Object[antall * 2 + 1];
            System.arraycopy(tabell, 0, newData, 0, antall);
            tabell = newData;
        }
    }

    @Override
    public void push(E e) {
        if (antall >= tabell.length)
            utvidTabell();
        tabell[antall++] = e;

    }

    @Override
    public E pop() { // FIXME: 30/09/2020 Ikke helt ferdig her.. poppop

        E e = tabell[--antall];

        for (int i = 0; i < tabell.length - 1; i++)
            tabell[i] = tabell[i + 1];

        tabell[antall] = null;


        return e;
    }

    @Override
    public E peek() {
        return antall > 0 ? tabell[antall - 1] : null;
    }

    public boolean isEmpty() {
        return tabell.length > 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > tabell.length)
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + tabell.length);
    }


    @Override
    public String toString() {
        return "TabellStakk: " + Arrays.toString(tabell);

    }

    public void trimToSize() {
        if (antall != tabell.length) {
            E[] newData = (E[]) (new Object[antall]);
            System.arraycopy(tabell, 0, newData, 0, antall);
            tabell = newData;
        }
    }
}


