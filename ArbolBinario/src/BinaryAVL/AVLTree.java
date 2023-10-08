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
                        nuevo.setFather(aux);
                        insertado = true;
                    } else {
                        aux = (NodoAVL<T>) aux.getLeft();
                    }
                } else {
                    if (aux.getRight() == null) {
                        aux.setRight(nuevo);
                        nuevo.setFather(aux);
                        insertado = true;
                    } else {
                        aux = (NodoAVL<T>) aux.getRight();
                    }
                }
            }
            size++;
            NodoAVL<T> padre = (NodoAVL<T>) nuevo.getFather();
            while (padre != null) {
                if (nuevo == padre) {
                    padre.decBF();
                } else {
                    padre.incBF();
                }

                if (padre.getBalanceFactor() == 0) {
                    return;
                }

                if (padre.getBalanceFactor() == 2 || padre.getBalanceFactor() == -2) {
                    balance(padre);
                    padre = (NodoAVL<T>) padre.getFather();
                } else {
                    padre = (NodoAVL<T>) padre.getFather();

                }
            }

        }

    }

    public boolean remove(T elemento) {
        NodoAVL<T> nodoR = (NodoAVL<T>) search(elemento);
        if (nodoR == null) {
            return false;
        }

        if (nodoR.getLeft() == null && nodoR.getRight() == null) {// hoja
            if (nodoR == root) {

                root.setElement(null);
                return true;
            } else {

                if (nodoR.getFather().getLeft() == nodoR) {
                    nodoR.getFather().setLeft(null);
                } else {
                    nodoR.getFather().setRight(null);

                }
            }

        } else {
            if (nodoR.getLeft() != null && nodoR.getRight() != null) {// tiene 2 hijos
                NodoAVL<T> aux = (NodoAVL<T>) nodoR.getRight();

                while (aux.getLeft() != null) {
                    aux = (NodoAVL<T>) aux.getLeft();

                }

                nodoR.setElement(aux.getElement());

                if (aux.getRight() != null) {
                    hang((NodoAVL<T>) aux.getRight(), (NodoAVL<T>) aux.getFather(), false);
                } else {
                    aux.getFather().setLeft(null);
                }

                nodoR = aux;
            } else {
                // 1 hijo
                NodoAVL<T> aux = (NodoAVL<T>) nodoR.getLeft();
                if (aux == null) {
                    aux = (NodoAVL<T>) nodoR.getRight();
                }
                if (nodoR == root) {
                    root = aux;
                } else {
                    hang(aux, (NodoAVL<T>) nodoR.getFather());
                }

            }
        }

        size--;
        NodoAVL<T> padre = (NodoAVL<T>) nodoR.getFather();
        while (padre != null) {
            if (padre.getLeft() == nodoR) {
                padre.incBF();
            } else {
                padre.decBF();
            }
            if (padre.getBalanceFactor() == 2 || padre.getBalanceFactor() == -2) {
                balance(padre);
                padre = (NodoAVL<T>) padre.getFather();
            } else {
                padre = (NodoAVL<T>) padre.getFather();
            }
        }

        return true;

    }

}