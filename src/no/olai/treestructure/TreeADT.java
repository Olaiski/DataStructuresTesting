package no.olai.treestructure;

import java.util.function.Consumer;

public interface TreeADT<E> {

    void addRoot(E value);

    Tree.Node<E> addNode(Tree.Node<E> parent, E value);
    Tree.Node<E> getRoot();


    void traverseLevelOrder(Consumer<E> c);
    void traversePreorder();
    void traversePostorder();
}
