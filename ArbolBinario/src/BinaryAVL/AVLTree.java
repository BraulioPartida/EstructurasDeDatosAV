package BinaryAVL;

import java.util.Iterator;

/**
 * AVLTree
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree.BinarySearchTree<T> {

    public AVLTree() {
        super();
    }

    @Override
    public void insert(T element) {
        NodoAVL<T> nuevo = new NodoAVL<>(element);
        if (isEmpty()) {
            root = nuevo;
        } else {
            NodoAVL<T> aux = (NodoAVL<T>) root;
            boolean insertado = false;
            while (!insertado) {
                if (element.compareTo(aux.getElement()) <= 0) {
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

            while (nuevo.getFather() != null) {
                if (nuevo == nuevo.getFather().getLeft()) {
                    ((NodoAVL<T>) nuevo.getFather()).decBF();
                } else {
                    ((NodoAVL<T>) nuevo.getFather()).incBF();
                }

                if (((NodoAVL<T>) nuevo.getFather()).getBalanceFactor() == 0) {
                    return;
                }

                if (((NodoAVL<T>) nuevo.getFather()).getBalanceFactor() == 2
                        || ((NodoAVL<T>) nuevo.getFather()).getBalanceFactor() == -2) {
                    balance((NodoAVL<T>) nuevo.getFather());

                    return;

                } else {
                    nuevo = (NodoAVL<T>) nuevo.getFather();

                }
            }

        }

    }

    public boolean remove(T element) {
        NodoAVL<T> nodoR = (NodoAVL<T>) search(element);
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
                    hang((NodoAVL<T>) aux.getRight(), (NodoAVL<T>) aux.getFather(), false);// true a la derecha
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

        while (nodoR.getFather() != null) {
            if (nodoR == nodoR.getFather().getLeft()) {
                ((NodoAVL<T>) nodoR.getFather()).incBF();
            } else {
                ((NodoAVL<T>) nodoR.getFather()).decBF();
            }

            switch (Math.abs(((NodoAVL<T>) nodoR.getFather()).getBalanceFactor())) {
                case 0:
                    nodoR = (NodoAVL<T>) nodoR.getFather();
                    break;
                case 1:
                    return true;
                case 2:
                    balance((NodoAVL<T>) nodoR.getFather());
                    break;
            }
        }

        return true;

    }

    public void balance(NodoAVL<T> alfa) {
        NodoAVL<T> beta, gama, b, c;
        if (alfa.getBalanceFactor() == -2) {// izq
            beta = (NodoAVL<T>) alfa.getLeft();
            if (alfa.getBalanceFactor() == 1) {// izq-der
                gama = (NodoAVL<T>) beta.getRight();
                b = (NodoAVL<T>) gama.getLeft();
                c = (NodoAVL<T>) gama.getRight();
                if (alfa == root) {
                    gama.setFather(null);
                    root = gama;

                } else {
                    hang(gama, (NodoAVL<T>) alfa.getFather());

                }
                hang(b, beta, true);
                hang(c, alfa, false);
                hang(beta, gama, true);
                hang(alfa, gama, false);
                gama.setBalanceFactor(0);
                beta.setBalanceFactor(0);
                if (gama.getBalanceFactor() == 1) {
                    beta.setBalanceFactor(-1);

                } else {
                    if (gama.getBalanceFactor() == -1) {
                        alfa.setBalanceFactor(1);
                    }
                }
                alfa.setBalanceFactor(0);
            } else {// izq-izq
                gama = (NodoAVL<T>) beta.getLeft();
                b = (NodoAVL<T>) gama.getRight();
                c = (NodoAVL<T>) beta.getRight();
                if (alfa == root) {
                    beta.setFather(null);
                    root = beta;
                } else {
                    hang(beta, (NodoAVL<T>) alfa.getFather());
                }
                hang(c, alfa, false);
                hang(gama, beta, false);
                hang(alfa, beta, true);
                if (beta.getBalanceFactor() == -1) {
                    alfa.setBalanceFactor(0);
                    beta.setBalanceFactor(0);

                } else {
                    alfa.setBalanceFactor(-1);
                    beta.setBalanceFactor(1);
                }
            }

        } else {// der
            beta = (NodoAVL<T>) alfa.getRight();
            if (beta.getBalanceFactor() == -1) {
                gama = (NodoAVL<T>) beta.getLeft();
                b = (NodoAVL<T>) gama.getLeft();
                c = (NodoAVL<T>) gama.getRight();
                if (alfa == root) {
                    gama.setFather(null);
                    root = gama;
                } else {
                    hang(gama, (NodoAVL<T>) alfa.getFather());
                }
                hang(b, alfa, true);
                hang(c, beta, false);
                hang(alfa, gama, false);
                hang(beta, gama, true);
                alfa.setBalanceFactor(0);
                beta.setBalanceFactor(0);
                if (gama.getBalanceFactor() == 1) {
                    alfa.setBalanceFactor(-1);
                } else {
                    if (gama.getBalanceFactor() == -1) {
                        beta.setBalanceFactor(1);
                    }
                }
                gama.setBalanceFactor(0);

            } else {// der-der
                gama = (NodoAVL<T>) beta.getRight();
                b = (NodoAVL<T>) beta.getLeft();
                c = (NodoAVL<T>) gama.getLeft();
                if (alfa == root) {
                    beta.setFather(null);
                    root = beta;
                } else {
                    hang(beta, (NodoAVL<T>) alfa.getFather());
                }
                hang(b, alfa, true);
                hang(alfa, beta, false);
                hang(gama, beta, true);

                if (beta.getBalanceFactor() == 1) {
                    alfa.setBalanceFactor(0);
                    beta.setBalanceFactor(0);
                } else {
                    alfa.setBalanceFactor(1);
                    beta.setBalanceFactor(-1);
                }
            }
        }
    }

    public void imprimirArbolEnOrden() {
        Iterator<T> it = levelOrder();
        AVLTree<T> abeto = new AVLTree<>();

        while (it.hasNext()) {
            abeto.insert(it.next());
        }

        imprimirArbolEnOrden((NodoAVL<T>) abeto.root, 0);

    }

    private void imprimirArbolEnOrden(NodoAVL<T> nodo, int nivel) {
        if (nodo != null) {
            imprimirArbolEnOrden((NodoAVL<T>) nodo.getRight(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }
            System.out.println(nodo.getElement());
            imprimirArbolEnOrden((NodoAVL<T>) nodo.getLeft(), nivel + 1);
        }
    }

    public static void main(String[] args) {
        AVLTree<Integer> arbol = new AVLTree<>();
        arbol.insert(10);
        arbol.insert(5);
        arbol.insert(15);
        arbol.insert(3);
        arbol.insert(7);
        arbol.insert(13);
        arbol.insert(17);
        arbol.insert(2);
        arbol.insert(4);
        arbol.insert(6);
        arbol.insert(8);
        arbol.insert(12);
        arbol.insert(14);
        arbol.insert(16);
        arbol.insert(18);
        arbol.insert(1);

        arbol.imprimirArbolEnOrden();

    }
}