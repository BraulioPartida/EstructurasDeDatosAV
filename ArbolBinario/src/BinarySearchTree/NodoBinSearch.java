package BinarySearchTree;

public class NodoBinSearch<T extends Comparable<T>> extends BinaryTree.NodoBin<T> {

    public NodoBinSearch(T elemento) {
        super(elemento);
    }

    public NodoBinSearch(T elemento, NodoBinSearch<T> padre) {
        super(elemento, padre);
    }

}
