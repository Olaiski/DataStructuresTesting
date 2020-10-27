package no.olai.treestructure;

public class TreeMain {
    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<>();
        tree.addRoot(1);
        Tree.Node<Integer> node1 = tree.getRoot();
        Tree.Node<Integer> node2 = tree.addNode(node1, 5);
        Tree.Node<Integer> node3 = tree.addNode(node1, 1);
        Tree.Node<Integer> node4 = tree.addNode(node2, 2);
        Tree.Node<Integer> node5 = tree.addNode(node2, 5);
        Tree.Node<Integer> node6 = tree.addNode(node2, 9);
        Tree.Node<Integer> node7 = tree.addNode(node3, 6);
        Tree.Node<Integer> node8 = tree.addNode(node3, 2);
        Tree.Node<Integer> node9 = tree.addNode(node5, 5);
        Tree.Node<Integer> node10 = tree.addNode(node6, 9);
        Tree.Node<Integer> node11 = tree.addNode(node6, 6);


        System.out.println("PreOrder: ");
        tree.traversePreorder();
        System.out.println("\nLevelOrder: ");
        tree.traverseLevelOrder(n -> System.out.print(n + " "));
        System.out.println("\nPostOrder:");
        tree.traversePostorder();


        /**
         *
         *           a
         *         b   c
         *          d e
         *
         */




    }
}
