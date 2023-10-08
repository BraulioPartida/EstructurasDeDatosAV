package BinaryTree;

public class NodoBin<T> {
    private T element;
    private NodoBin<T> izq, der, padre;

    public int numDescendents() {
        int num = 0;
        if (izq != null) {
            num += izq.numDescendents() + 1;
        }
        if (der != null) {
            num += der.numDescendents() + 1;
        }
        return num;
    }

    public NodoBin(T element) {
        this.element = element;
        izq = der = padre = null;
    }

    public NodoBin(T element, NodoBin<T> padre) {
        this(element);
        this.padre = padre;
    }

    public T getElement() {
        return element;
    }

    public NodoBin<T> getLeft() {
        return izq;
    }

    public NodoBin<T> getRight() {
        return der;
    }

    public NodoBin<T> getFather() {
        return padre;
    }

    public void setLeft(NodoBin<T> izq) {
        this.izq = izq;
    }

    public void setFather(NodoBin<T> padre) {
        this.padre = padre;
    }

    public void setRight(NodoBin<T> der) {
        this.der = der;
    }

    public void setElement(T element) {
        this.element = element;
    }

}