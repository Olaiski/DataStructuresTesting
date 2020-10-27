package no.olai.exercises;

public class TabellStakkMain {
    public static void main(String[] args) {


        TabellStakk<String> stakk = new TabellStakk<>();
        System.out.println(stakk);
        stakk.push("A");
        stakk.push("B");
        System.out.println(stakk);
        stakk.push("C");
        System.out.println(stakk);
        stakk.trimToSize();
        System.out.println(stakk);
        stakk.push("D");
        System.out.println(stakk);
        System.out.println(stakk.peek());
        System.out.println(stakk.pop());
        System.out.println(stakk);

    }
}
