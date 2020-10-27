package no.olai.list.linkedlist;

public class CircularMain {
    public static void main(String[] args) {


        CircularLinkedList<Character> list = new CircularLinkedList<>();
//        list.addFirst('A');
//        list.add('B');

        for(char a = 'a'; a <= 'h'; a++)
            list.add(a);

        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        System.out.println(list.contains('a'));
        System.out.println(list.contains('h'));
        System.out.println(list.contains('d'));
        System.out.println(list.contains('i'));


        System.out.println("\n" + list);
        System.out.println("removefirst(): " + list.removeFirst());
        System.out.println(list);
        System.out.println("removelast(): " + list.removeLast());
        System.out.println(list);
        System.out.println("remove(3): " + list.remove(3));
        System.out.println(list);

        System.out.println("\n");
        list.clear();
        System.out.println(list);

        for(char a = 'a'; a <= 'h'; a++)
            list.add(a);
        System.out.println(list);

    }
}
