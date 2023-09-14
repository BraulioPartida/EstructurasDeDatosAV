package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    protected NodoBin<T> root;
    protected int size;

    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public boolean contains(T elemento) {
        return contains(root, elemento) != null;
    }

    public Iterator<T> preOrder() {
        ArrayList<T> arr = new ArrayList<>();
        preOrder(root, arr);
        return arr.iterator();
    }

    public Iterator<T> postOrder() {
        ArrayList<T> arr = new ArrayList<>();
        postOrder(root, arr);
        return arr.iterator();
    }

    public Iterator<T> inOrder() {
        ArrayList<T> arr = new ArrayList<>();
        inOrder(root, arr);
        return arr.iterator();
    }

    public Iterator<T> levelOrder() {
        Queue<NodoBin<T>> cola = new LinkedList<>();
        ArrayList<T> arr = new ArrayList<>();
        cola.add(root);
        while (!cola.isEmpty()) {
            NodoBin<T> nodo = cola.remove();
            arr.add(nodo.getElement());
            if (nodo.getLeft() != null) {
                cola.add(nodo.getLeft());
            }
            if (nodo.getRight() != null) {
                cola.add(nodo.getRight());
            }
        }
        return arr.iterator();
    }

    private void postOrder(NodoBin<T> nodo, ArrayList<T> arr) {
        if (nodo == null) {
            return;
        }
        postOrder(nodo.getLeft(), arr);
        postOrder(nodo.getRight(), arr);
        arr.add(nodo.getElement());
    }

    private void preOrder(NodoBin<T> nodo, ArrayList<T> arr) {
        if (nodo == null) {
            return;
        }
        arr.add(nodo.getElement());
        preOrder(nodo.getLeft(), arr);
        preOrder(nodo.getRight(), arr);
    }

    private void inOrder(NodoBin<T> nodo, ArrayList<T> arr) {
        if (nodo == null) {
            return;
        }
        inOrder(nodo.getLeft(), arr);
        arr.add(nodo.getElement());
        inOrder(nodo.getRight(), arr);
    }

    private NodoBin<T> contains(NodoBin<T> nodo, T elemento) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getElement().equals(elemento)) {
            return nodo;
        }
        NodoBin<T> izq = contains(nodo.getLeft(), elemento);
        if (izq != null) {
            return izq;
        }
        return contains(nodo.getRight(), elemento);
    }

    public int height() {
        return height(root);
    }

    private int height(NodoBin<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(height(nodo.getLeft()), height(nodo.getRight()));
    }

}