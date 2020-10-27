package no.olai.list;

import java.lang.reflect.Array;
import java.util.Collection;

public interface MyList<E> extends Collection<E> {


    // Add new element at the specified index in the list
    void add(int index, E e);

    // Get specified index
    E get(int index);

    /* Return the index of the first matching element in this list
       Return -1 if no match. */
    int indexOf(Object e);

    /* Return index of the last matching element in this list
       Return -1 if no match. */
    int lastIndexOf(E e);

    /* Replace th element at the specified position in this list
        with the specified element and return the new set. */
    E set(int index, E e);

    /* Remove the elements at the specified pos. in this list
     * Shift any subsequent elements to the left. Return the element that was removed from the list */
    E remove(int index);


    @Override // Add a new element at the end of the list
    default boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override // Returns true of this list contains no elements
    default boolean isEmpty() {
        return size() == 0;
    }


    /* Remove the first occurrence of the element e from the list.
       Shift any subsequent elements to the left.
        Return true if element is removed */
    @Override
    default boolean remove(Object e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        return false;
    }

    @Override
    default boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
            return true;
    }


    @Override
    default boolean addAll(Collection<? extends E> c) {
        for (E e : c) if (add(e)) return true;

        return false;
    }


    @Override
    default boolean removeAll(Collection<?> c) {
        for (Object e : c)
            if (remove(e))
                return true;
            return false;
    }

    @Override // FIXME: 29/09/2020 Funker ikke helt..
    default boolean retainAll(Collection<?> c) {
        boolean changed = false;
        for (int i = size(); i >= 0; i--) {
            Object obj = get(i);
            if (!c.contains(obj)) {
                remove(i);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    default Object[] toArray() {
        return this.toArray(new Object[size()]);
    }

    @Override
    default <T> T[] toArray(T[] a) {
        int size = size();
        if (a.length < size) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        } else if (a.length > size) {
            a[size] = null;
        }

        int i = 0;
        for (E e : this) {
            a[i] = (T) e;
            i++;
        }
        return a;
    }






}
