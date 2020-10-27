package no.olai.stacksqueue.heap;

public class PriorityQueueMain {
    public static void main(String[] args) {


        Patient p1 = new Patient("John", 2);
        Patient p2 = new Patient("Jim", 1);
        Patient p3 = new Patient("Tim", 5);
        Patient p4 = new Patient("Cindy", 7);

        MyPriorityQueue<Patient> priorityQueue = new MyPriorityQueue<>();
        priorityQueue.enqueue(p1);
        priorityQueue.enqueue(p2);
        priorityQueue.enqueue(p3);
        priorityQueue.enqueue(p4);

        while (priorityQueue.getSize() > 0)
            System.out.println(priorityQueue.dequeue() + " ");

        Integer max = 42;
        Integer right = 59;
        if (max.compareTo(right) < 0) System.out.println("Mindre?");

    }

    static class Patient implements Comparable<Patient> {
        private String name;
        private int priority;

        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return name + "(priority: " + priority + ")";
        }

        @Override
        public int compareTo(Patient patient) {
            return this.priority - patient.priority;
        }
    }
}
