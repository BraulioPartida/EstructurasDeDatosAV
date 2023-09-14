package BinaryTree;

import java.util.Iterator;

public interface BinaryTreeADT<T> {
    public boolean isEmpty();

    public int size();

    public boolean contains(T elemento);

    public int height();

    public Iterator<T> preOrder();

    public Iterator<T> postOrder();

    public Iterator<T> inOrder();

    public Iterator<T> levelOrder();

}