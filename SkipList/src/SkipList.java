public class SkipList<T extends Comparable<T>> {
    NodoSkip<T> cabeza;
    NodoSkip<T> cola;
    int niveles, cant;

    public SkipList() {
        cabeza = new NodoSkip<T>(null);
        cola = new NodoSkip<T>(null);
        cabeza.setDer(cola);
        cola.setIzq(cabeza);
        niveles = 1;
        cant = 0;
    }

    private NodoSkip<T> buscarPr(T elem) {
        int i;
        NodoSkip<T> actual = cabeza;
        for (i = 1; i <= niveles; i++) {
            while (actual.getDer().getElem() != null && actual.getDer().getElem().compareTo(elem) <= 0)
                actual = actual.getDer();
            if (i < niveles)
                actual = actual.getAba();
        }
        return actual;
    }

    public boolean buscar(T elem) {
        NodoSkip<T> actual = buscarPr(elem);
        boolean resp = false;
        if (actual.getElem() != null && actual.getElem().equals(elem))
            resp = true;
        return resp;
    }

    public boolean borrar(T elem) {
        NodoSkip<T> actual = buscarPr(elem);
        boolean resp = false;
        if (actual.getElem() != null && actual.getElem().equals(elem)) {
            resp = true;
            cant--;
            actual.getIzq().setDer(actual.getDer());
            actual.getDer().setIzq(actual.getIzq());
            while (actual.getArr() != null) {
                actual = actual.getArr();
                actual.getIzq().setDer(actual.getDer());
                actual.getDer().setIzq(actual.getIzq());
            }

        }
        return resp;
    }

    public void agregaNivel() {
        niveles++;
        NodoSkip<T> cabezaAnterior = cabeza;
        NodoSkip<T> nuevaCabeza = new NodoSkip<T>(null);
        NodoSkip<T> colaAnterior = cola;
        NodoSkip<T> nuevaCola = new NodoSkip<T>(null);
        cabezaAnterior.setArr(nuevaCabeza);
        colaAnterior.setArr(nuevaCola);
        nuevaCabeza.setAba(cabezaAnterior);
        nuevaCola.setAba(colaAnterior);
        nuevaCabeza.setDer(nuevaCola);
        nuevaCola.setIzq(nuevaCabeza);
        cabeza = nuevaCabeza;
        cola = nuevaCola;
    }

    public void inserta(T elem) {
        NodoSkip<T> actual = buscarPr(elem);
        NodoSkip<T> nuevo = new NodoSkip<T>(elem);
        cant++;
        nuevo.setIzq(actual);
        nuevo.setDer(actual.getDer());
        actual.setDer(nuevo);
        nuevo.getDer().setIzq(nuevo);
        int i = 1;
        while (Math.random() > 0.5 && niveles < Math.log10(cant) / Math.log10(2)) {
            if (i >= niveles)
                agregaNivel();

            while (actual.getArr() == null)
                actual = actual.getIzq();
            actual = actual.getArr();
            NodoSkip<T> nuevoArr = new NodoSkip<T>(elem);
            nuevoArr.setIzq(actual);
            nuevoArr.setDer(actual.getDer());
            actual.setDer(nuevoArr);
            nuevoArr.getDer().setIzq(nuevoArr);
            nuevoArr.setAba(nuevo);
            nuevo.setArr(nuevoArr);
            nuevo = nuevoArr;
            i++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodoSkip<T> current = cabeza;

        while (current != null) {
            NodoSkip<T> temp = current;
            while (temp != null) {
                if (temp.getElem() != null) {
                    sb.append(temp.getElem().toString());
                } else {
                    sb.append("null");
                }
                sb.append(" -> ");
                temp = temp.getDer();
            }
            sb.append("\n");
            current = current.getAba();
        }

        return sb.toString();
    }

    public void printLevelCounts() {
        NodoSkip<T> currentLevel = cabeza;
        int level = 0;
        while (currentLevel != null) {
            int count = 0;
            NodoSkip<T> currentNode = currentLevel;
            while (currentNode != null) {
                count++;
                currentNode = currentNode.getDer();
            }
            System.out.println("nivel " + (niveles - level) + ": " + count + " nodes");
            level++;
            currentLevel = currentLevel.getAba();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            SkipList<Integer> skipList = new SkipList<Integer>();
            for (int j = 1; j <= 1022; j++)
                skipList.inserta(j);
            skipList.printLevelCounts();
        }

    }

}