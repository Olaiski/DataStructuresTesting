package no.olai.treestructure;

import java.util.LinkedList;
import java.util.function.Consumer;

public class Tree<E> implements TreeADT<E>{

    private Node<E> root;

    @Override
    public void addRoot(E value) {
        if (root == null) {
            root = new Node<>(new LinkedList<>(), value);
        }
        else {
            throw new IllegalStateException("Root exists");
        }
    }

    @Override
    public Node<E> addNode(Node<E> parent, E value) {
        if (parent == null) throw new NullPointerException("No parent");
        else {
            Node<E> newNode = new Node<>(new LinkedList<>(), value);
            parent.getChildren().addLast(newNode);
            return newNode;
        }
    }

    
    private void traverseLevelOrder(Node<E> n, Consumer<E> c) {
        c.accept(n.value);
        n.children.forEach((child) -> traverseLevelOrder(child, c));
    }

    @Override
    public void traverseLevelOrder(Consumer<E> c) {
        LinkedList<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> n = queue.remove();
            c.accept(n.value);
            for (Node<E> child : n.children)
                queue.add(child);
        }
    }

    @Override
    public void traversePreorder() {
        if (root != null) root.traversePreOrder();
    }

    @Override
    public void traversePostorder() {
        if (root != null) root.traversePostOrder();
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    public static class Node<E> {
        private E value;
        private LinkedList<Node<E>> children;


        public LinkedList<Node<E>> getChildren() {
            return children;
        }

        public E getValue() {
            return value;
        }

        public Node(LinkedList<Node<E>> children, E value) {
            this.value = value;
            this.children = children;
        }


        // (Root, Left, Right)
        void traversePreOrder() {
            System.out.print(value + " ");
            for (Node<E> child : children)
                child.traversePreOrder();

        }

        // Postorder (Left, Right, Root)
        void traversePostOrder() {
            for (Node<E> child : children)
                child.traversePostOrder();
            System.out.print(value + " ");
        }

    }
}
