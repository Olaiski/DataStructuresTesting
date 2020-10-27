package no.olai.stacksqueue;

public class StackQueueMain {
    public static void main(String[] args) {

        GenericStack<String> stack = new GenericStack<>();
        stack.push("Tom");
        System.out.println("(1) " + stack);

        stack.push("Susan");
        System.out.println("(2) " + stack);

        stack.push("Kim");
        stack.push("Michael");
        System.out.println("(3) " + stack);

        System.out.println("(4) " + stack.pop());
        System.out.println("(5) " + stack.pop());
        System.out.println("(6) " + stack);

        System.out.println();
        GenericQueue<String> queue = new GenericQueue<>();
        queue.enqueue("Tom");
        System.out.println("(7) " + queue);

        queue.enqueue("Susan");
        System.out.println("(8) " + queue);

        queue.enqueue("Kim");
        queue.enqueue("Michael");
        System.out.println("(9) " + queue);

        System.out.println("(10) " + queue.dequeue());
        System.out.println("(11) " + queue.dequeue());
        System.out.println("(12) " + queue);


        System.out.println("\n------------------------\n");


        GenericDoubleEndedQueue<String> gdeq = new GenericDoubleEndedQueue<>();
        gdeq.addFirst("Tom");
        System.out.println("(13) " + gdeq);

        gdeq.addFirst("Susan");
        System.out.println("(14) " + gdeq);

        gdeq.addLast("Cindy");
        System.out.println("(15) " + gdeq);

        gdeq.addLast("Kim");
        System.out.println("(16) " + gdeq);

        System.out.println("(17) " + gdeq.getFirst());
        System.out.println("(18) " + gdeq.getLast());

        System.out.println(gdeq.removeFirst());
        System.out.println(gdeq.removeLast());

        System.out.println("(19) " + gdeq);

    }
}
