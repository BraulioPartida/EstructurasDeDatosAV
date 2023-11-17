public class NodoSkip<T> {
    T elem;
    NodoSkip<T> arr;
    NodoSkip<T> aba;
    NodoSkip<T> izq;
    NodoSkip<T> der;

    public NodoSkip(T elem) {
        this.elem = elem;
    }

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public NodoSkip<T> getArr() {
        return arr;
    }

    public void setArr(NodoSkip<T> arr) {
        this.arr = arr;
    }

    public NodoSkip<T> getAba() {
        return aba;
    }

    public void setAba(NodoSkip<T> aba) {
        this.aba = aba;
    }

    public NodoSkip<T> getIzq() {
        return izq;
    }

    public void setIzq(NodoSkip<T> izq) {
        this.izq = izq;
    }

    public NodoSkip<T> getDer() {
        return der;
    }

    public void setDer(NodoSkip<T> der) {
        this.der = der;
    }

    @Override
    public String toString() {
        if (elem == null)
            return "null";
        return elem.toString();
    }

}