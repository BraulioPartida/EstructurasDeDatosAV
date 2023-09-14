package BinarySearchTree;

public class NodoBinSearch<T extends Comparable<T>> extends BinaryTree.NodoBin<T> {

    public NodoBinSearch(T elemento) {
        super(elemento);
    }

    public NodoBinSearch(T elemento, NodoBinSearch<T> padre) {
        super(elemento, padre);
    }

    public void hang(NodoBinSearch<T> hijo) {
        if (hijo.getElement().compareTo(this.getElement()) <= 0) {
            this.setLeft(hijo);
        } else {
            this.setRight(hijo);
        }
    }

    public void hangAVL(NodoBinSearch<T> hijo, char direccion) {
        if (direccion == 'I') {
            this.setLeft(hijo);
        } else {
            this.setRight(hijo);
        }
        if (hijo != null) {
            hijo.setPadre(this);
        }
    }

}
