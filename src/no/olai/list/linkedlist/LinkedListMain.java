package no.olai.list.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {

        MyLinkedList<Character> list = new MyLinkedList<>();
        for (char i = 'A'; i <= 'Z'; i++)
            list.add(i);

        System.out.println("\n\n---------------------- MyLinkedList Testing ----------------------\nAdding:");
        System.out.println("    " + list + "\nSize: " + list.size());


        System.out.println("\nGets:");
        System.out.println("    get(1): " + list.get(1));
        System.out.println("    get(5): " + list.get(5));
        System.out.println("    get(12): " + list.get(12));
        System.out.println("    get(26): " + list.get(26));
        System.out.println("    getFirst(): " + list.getFirst());
        System.out.println("    getLast(): " + list.getLast());


        System.out.println("\nindexOf:");
        System.out.println("    iO('A'): " + list.indexOf('A'));
        System.out.println("    iO('F'): " + list.indexOf('F'));
        System.out.println("    iO('Z'): " + list.indexOf('Z'));
        System.out.println("    iO('Å'): " + list.indexOf('Å'));


        System.out.println("\nRemoveFirst():");
        System.out.println("    " + list);
        list.removeFirst();
        System.out.println("    " + list);


        System.out.println("RemoveLast():");
        list.removeLast();
        System.out.println("    " + list);

        System.out.println("\naddFirst(): 'A'");
        list.addFirst('A');
        System.out.println("addLast(): 'Z'");
        list.addLast('Z');
        System.out.println("add(26,'Æ'), add(27,'Ø'), add(28,'Å')");
        list.add(26, 'Æ');
        list.add(27, 'Ø');
        list.add(28, 'Å');
        list.add(7, 'B');
        System.out.println("    " + list);


        System.out.println("\nlastIndexOf('Å'): " + list.lastIndexOf('Å'));
        System.out.println("lastIndexOf('B'): " + list.lastIndexOf('B'));

        System.out.println("    " + list);

        System.out.println("\nset(5, 'T'): " + list.set(5, 'T'));
        System.out.println("set(0, '5'): " + list.set(0, '5'));
        System.out.println("    " + list);


        System.out.println("\ncontains():");
        System.out.println("T?: " + list.contains('T'));
        System.out.println("5?: " + list.contains('5'));
        System.out.println("Æ?: " + list.contains('Æ'));
        System.out.println("/: " + list.contains('/'));


    }
}
