/**
 * NodoSkip
 */
public class NodoSkip<T extends Comparable<T>> {
    T element;
    NodoSkip<T> up, down, left, right;
    int level;

    public NodoSkip(T element) {
        this.element = element;
        up = down = left = right = null;
        level = 0;
    }

}