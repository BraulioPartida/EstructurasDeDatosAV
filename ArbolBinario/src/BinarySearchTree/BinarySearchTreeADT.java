package BinarySearchTree;

/**
 * BinarySearchTreeADT
 */
public interface BinarySearchTreeADT<T> extends BinaryTree.BinaryTreeADT<T> {

    public void insert(T elemento);

    // public boolean remove(T elemento);

    // public T removeMin();

    // public T removeMax();

    public T findMin();

    public T findMax();

}
