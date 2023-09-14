package BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree.LinkedBinaryTree<T>
        implements BinarySearchTreeADT<T> {

    private NodoBinSearch<T> root;

    public BinarySearchTree() {
        super();
    }

    public void insert(T elemento) {
        NodoBinSearch<T> nuevo = new NodoBinSearch<>(elemento);
        if (isEmpty()) {
            root = nuevo;
        } else {
            NodoBinSearch<T> aux = root;
            boolean insertado = false;
            while (!insertado) {
                if (elemento.compareTo(aux.getElement()) <= 0) {
                    if (aux.getLeft() == null) {
                        aux.setLeft(nuevo);
                        insertado = true;
                    } else {
                        aux = (NodoBinSearch<T>) aux.getLeft();
                    }
                } else {
                    if (aux.getRight() == null) {
                        aux.setRight(nuevo);
                        insertado = true;
                    } else {
                        aux = (NodoBinSearch<T>) aux.getRight();
                    }
                }
            }
        }
        size++;
    }

    public NodoBinSearch<T> find(T element) {
        NodoBinSearch<T> aux = root;
        while (aux != null && aux.getElement().compareTo(element) != 0) {
            if (element.compareTo(aux.getElement()) < 0) {
                aux = (NodoBinSearch<T>) aux.getLeft();
            } else {
                aux = (NodoBinSearch<T>) aux.getRight();
            }
        }
        return aux;
    }

    public T findMin() {
        NodoBinSearch<T> aux = root;
        if (isEmpty()) {
            return null;
        }
        while (aux.getLeft() != null) {
            aux = (NodoBinSearch<T>) aux.getLeft();
        }
        return aux.getElement();
    }

    public T findMax() {
        NodoBinSearch<T> aux = root;
        if (isEmpty()) {
            return null;
        }
        while (aux.getRight() != null) {
            aux = (NodoBinSearch<T>) aux.getRight();
        }
        return aux.getElement();
    }

}
