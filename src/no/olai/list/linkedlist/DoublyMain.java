package no.olai.list.linkedlist;

import java.util.ListIterator;

public class DoublyMain {
    public static void main(String[] args) {


        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        for(char a = 'a'; a <= 'g'; a++)
            list.addFirst(a);

        System.out.println(list);

        System.out.println("\n");
        list.add(2, 'H');
        list.add(list.size(), 'Å');
        list.add(0,'S');
        list.add(4,'Ø');
        list.addLast('a');
        System.out.println(list);
        System.out.println(list.indexOf('Ø'));


        System.out.println(list.lastIndexOf('a'));



    }
}
