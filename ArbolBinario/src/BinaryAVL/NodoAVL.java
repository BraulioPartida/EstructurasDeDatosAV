package BinaryAVL;

/**
 * NodoAVL
 */
public class NodoAVL<T extends Comparable<T>> extends BinarySearchTree.NodoBinSearch<T> {
    private int balanceFactor;

    public NodoAVL(T elemento) {
        super(elemento);
        balanceFactor = 0;
    }

    public NodoAVL(T elemento, NodoAVL<T> padre) {
        super(elemento, padre);
        balanceFactor = 0;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

}