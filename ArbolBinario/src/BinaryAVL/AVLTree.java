package BinaryAVL;

/**
 * AVLTree
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree.BinarySearchTree<T> {
    private NodoAVL<T> root;

    public AVLTree() {
        super();
    }

    @Override
    public void insert(T elemento) {
        NodoAVL<T> nuevo = new NodoAVL<>(elemento);
        if (isEmpty()) {
            root = nuevo;
        } else {
            NodoAVL<T> aux = root;
            boolean insertado = false;
            while (!insertado) {
                if (elemento.compareTo(aux.getElement()) <= 0) {
                    if (aux.getLeft() == null) {
                        aux.setLeft(nuevo);
                        nuevo.setPadre(aux);
                        insertado = true;
                    } else {
                        aux = (NodoAVL<T>) aux.getLeft();
                    }
                } else {
                    if (aux.getRight() == null) {
                        aux.setRight(nuevo);
                        nuevo.setPadre(aux);
                        insertado = true;
                    } else {
                        aux = (NodoAVL<T>) aux.getRight();
                    }
                }
            }
            size++;
            NodoAVL<T> padre = (NodoAVL<T>) nuevo.getPadre();
            updateBalanceFactor(nuevo);
            while (padre != null) {
                updateBalanceFactor(padre);
                if (padre.getBalanceFactor() >= 2 || padre.getBalanceFactor() <= -2) {
                    balance(padre);
                }
                padre = (NodoAVL<T>) padre.getPadre();
            }

        }

    }

    public void updateBalanceFactor(NodoAVL<T> nodo) {
        nodo.setBalanceFactor(height(nodo.getLeft()) - height(nodo.getRight()));
    }

}