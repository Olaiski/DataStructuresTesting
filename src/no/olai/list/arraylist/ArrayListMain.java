package no.olai.list.arraylist;

public class ArrayListMain {
    public static void main(String[] args) {


        System.out.println("---------------------- MyArrayList Testing ----------------------\nAdding:");
        MyArrayList<Character> myArrayListCharacter = new MyArrayList<>();
       for (char i = 'A'; i <= 'Z'; i++)
           myArrayListCharacter.add(i);

        System.out.println(myArrayListCharacter);
        System.out.println("Size: " + myArrayListCharacter.size() + "\n");

        System.out.println("Removing B / index(1):");
        myArrayListCharacter.remove(1);
        System.out.println(myArrayListCharacter);

        System.out.println("Size: " + myArrayListCharacter.size());


        System.out.println("\nIndexOf(B): ");
        System.out.println(myArrayListCharacter.indexOf('B'));
        System.out.println("IndexOf(A): ");
        System.out.println(myArrayListCharacter.indexOf('A'));
        System.out.println("IndexOf(Z): ");
        System.out.println(myArrayListCharacter.indexOf('Z'));


        System.out.println("\nAdd(B) to index 1");
        myArrayListCharacter.add(1, 'B');
        System.out.println(myArrayListCharacter);
        System.out.println("Size: " + myArrayListCharacter.size() + "\n");


        System.out.println("Clear: ");
        myArrayListCharacter.clear();
        System.out.println(myArrayListCharacter);
        System.out.println("Size: " + myArrayListCharacter.size());
    }
}
