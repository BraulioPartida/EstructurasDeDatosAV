public class NodoBin<T> {
    private T elemento;
    private NodoBin<T> izq, der, padre;

    public int numDescendientes() {
        int num = 0;
        if (izq != null) {
            num += izq.numDescendientes() + 1;
        }
        if (der != null) {
            num += der.numDescendientes() + 1;
        }
        return num;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoBin<T> getIzq() {
        return izq;
    }

    public void setIzq(NodoBin<T> izq) {
        this.izq = izq;
    }

    public NodoBin<T> getDer() {
        return der;
    }

    public void setDer(NodoBin<T> der) {
        this.der = der;
    }

    public NodoBin<T> getPadre() {
        return padre;
    }

    public void setPadre(NodoBin<T> padre) {
        this.padre = padre;
    }

}