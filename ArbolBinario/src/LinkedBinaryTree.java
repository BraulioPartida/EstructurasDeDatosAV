import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    private NodoBin<T> raiz;
    private int cont;

    public LinkedBinaryTree() {
        raiz = null;
        cont = 0;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public int size() {
        return cont;
    }

    public boolean find(T elemento) {
        return find(raiz, elemento) != null;
    }

    public Iterator<T> preOrder() {
        ArrayList<T> arr = new ArrayList<>();
        preOrder(raiz, arr);
        return arr.iterator();
    }

    public Iterator<T> postOrder() {
        ArrayList<T> arr = new ArrayList<>();
        postOrder(raiz, arr);
        return arr.iterator();
    }

    public Iterator<T> inOrder() {
        ArrayList<T> arr = new ArrayList<>();
        inOrder(raiz, arr);
        return arr.iterator();
    }

    private void postOrder(NodoBin<T> nodo, ArrayList<T> arr) {
        if (nodo == null) {
            return;
        }
        postOrder(nodo.getIzq(), arr);
        postOrder(nodo.getDer(), arr);
        arr.add(nodo.getElemento());
    }

    private void preOrder(NodoBin<T> nodo, ArrayList<T> arr) {
        if (nodo == null) {
            return;
        }
        arr.add(nodo.getElemento());
        preOrder(nodo.getIzq(), arr);
        preOrder(nodo.getDer(), arr);
    }

    private void inOrder(NodoBin<T> nodo, ArrayList<T> arr) {
        if (nodo == null) {
            return;
        }
        inOrder(nodo.getIzq(), arr);
        arr.add(nodo.getElemento());
        inOrder(nodo.getDer(), arr);
    }

    private NodoBin<T> find(NodoBin<T> nodo, T elemento) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getElemento().equals(elemento)) {
            return nodo;
        }
        NodoBin<T> izq = find(nodo.getIzq(), elemento);
        if (izq != null) {
            return izq;
        }
        return find(nodo.getDer(), elemento);
    }

}