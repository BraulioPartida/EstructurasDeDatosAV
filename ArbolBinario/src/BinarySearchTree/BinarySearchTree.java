package BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree.LinkedBinaryTree<T>
        implements BinarySearchTreeADT<T> {

    public BinarySearchTree() {
        super();
    }

    public void insert(T elemento) {
        NodoBinSearch<T> nuevo = new NodoBinSearch<>(elemento);
        if (isEmpty()) {
            root = nuevo;
        } else {
            NodoBinSearch<T> aux = (NodoBinSearch<T>) root;
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

    public NodoBinSearch<T> search(T element) {
        NodoBinSearch<T> aux = (NodoBinSearch<T>) root;
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
        NodoBinSearch<T> aux = (NodoBinSearch<T>) root;
        if (isEmpty()) {
            return null;
        }
        while (aux.getLeft() != null) {
            aux = (NodoBinSearch<T>) aux.getLeft();
        }
        return aux.getElement();
    }

    public T findMax() {
        NodoBinSearch<T> aux = (NodoBinSearch<T>) root;
        if (isEmpty()) {
            return null;
        }
        while (aux.getRight() != null) {
            aux = (NodoBinSearch<T>) aux.getRight();
        }
        return aux.getElement();
    }

    public T antecesorComun(NodoBinSearch<T> nodo1, NodoBinSearch<T> nodo2) {
        NodoBinSearch<T> aux = (NodoBinSearch<T>) root;
        while (aux != null) {
            if (nodo1.getElement().compareTo(aux.getElement()) < 0
                    && nodo2.getElement().compareTo(aux.getElement()) < 0) {
                aux = (NodoBinSearch<T>) aux.getLeft();
            } else if (nodo1.getElement().compareTo(aux.getElement()) > 0
                    && nodo2.getElement().compareTo(aux.getElement()) > 0) {
                aux = (NodoBinSearch<T>) aux.getRight();
            } else {
                return aux.getElement();
            }
        }
        return null;
    }

    public void hang(NodoBinSearch<T> hijo, NodoBinSearch<T> padre) {
        if (hijo.getElement().compareTo(padre.getElement()) <= 0) {
            padre.setLeft(hijo);
        } else {
            padre.setRight(hijo);
        }
        if (hijo != null) {
            hijo.setFather(padre);

        }
    }

    public void hang(NodoBinSearch<T> hijo, NodoBinSearch<T> padre, boolean dirrecion) {
        if (dirrecion) {
            padre.setRight(hijo);
        } else {
            padre.setLeft(hijo);
        }
        if (hijo != null) {
            hijo.setFather(padre);

        }
    }

}
