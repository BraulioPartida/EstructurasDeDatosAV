package BinaryAVL;

public class ArbolAVL<T extends Comparable<T>> {
    private NodoAVL<T> root;

    public ArbolAVL() {
        root = null;
    }

    // Realiza una rotación a la izquierda
    private NodoAVL<T> leftRotate(NodoAVL<T> y) {
        NodoAVL<T> x = y.getRight();
        NodoAVL<T> T2 = x.getLeft();

        x.setLeft(y);
        y.setRight(T2);

        y.updateHeight();
        x.updateHeight();

        return x;
    }

    // Realiza una rotación a la derecha
    private NodoAVL<T> rightRotate(NodoAVL<T> x) {
        NodoAVL<T> y = x.getLeft();
        NodoAVL<T> T2 = y.getRight();

        y.setRight(x);
        x.setLeft(T2);

        x.updateHeight();
        y.updateHeight();

        return y;
    }

    // Inserta un valor en el árbol
    public void insert(T data) {
        root = insertRec(root, data);
    }

    private NodoAVL<T> insertRec(NodoAVL<T> node, T data) {
        if (node == null) {
            return new NodoAVL<T>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insertRec(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insertRec(node.getRight(), data));
        } else {
            // No se permiten duplicados
            return node;
        }

        node.updateHeight();
        int balance = node.getBalanceFactor();

        // Realizar rotaciones para equilibrar el árbol
        if (balance > 1) {
            if (data.compareTo(node.getLeft().getData()) < 0) {
                return rightRotate(node);
            } else {
                node.setLeft(leftRotate(node.getLeft()));
                return rightRotate(node);
            }
        }
        if (balance < -1) {
            if (data.compareTo(node.getRight().getData()) > 0) {
                return leftRotate(node);
            } else {
                node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
            }
        }

        return node;
    }

    // Borra un valor del árbol
    public void borra(T data) {
        root = deleteRec(root, data);
    }

    private NodoAVL<T> deleteRec(NodoAVL<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(deleteRec(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(deleteRec(node.getRight(), data));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                NodoAVL<T> temp = (node.getLeft() != null) ? node.getLeft() : node.getRight();

                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                NodoAVL<T> temp = minValueNode(node.getRight());
                node.setData(temp.getData());
                node.setRight(deleteRec(node.getRight(), temp.getData()));
            }
        }

        if (node == null) {
            return null;
        }

        node.updateHeight();
        int balance = node.getBalanceFactor();

        // Realizar rotaciones para equilibrar el árbol
        if (balance > 1) {
            if (node.getLeft().getBalanceFactor() >= 0) {

                return rightRotate(node);
            } else {
                node.setLeft(leftRotate(node.getLeft()));
                return rightRotate(node);
            }
        }
        if (balance < -1) {
            if (node.getRight().getBalanceFactor() <= 0) {
                return leftRotate(node);
            } else {
                node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
            }
        }

        return node;
    }

    private NodoAVL<T> minValueNode(NodoAVL<T> node) {
        NodoAVL<T> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public void printGraph() {
        printGraph(root, 0);
    }

    private void printGraph(NodoAVL<T> nodo, int nivel) {
        if (nodo != null) {
            printGraph(nodo.getRight(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }
            System.out.println(nodo.getData());
            printGraph(nodo.getLeft(), nivel + 1);

        }
    }

    public static void main(String[] args) {
        ArbolAVL<Integer> abeto = new ArbolAVL<>();

        abeto.insert(100);
        abeto.insert(300);
        abeto.insert(400);
        abeto.insert(50);
        abeto.insert(200);
        abeto.insert(250);
        abeto.insert(75);
        abeto.insert(350);
        abeto.insert(500);
        abeto.insert(375);
        abeto.printGraph();
        System.out.println("----------------------------------------------------------");

        abeto.borra(500);
        abeto.borra(400);
        abeto.borra(200);

        System.out.println();
        abeto.printGraph();

    }
}
