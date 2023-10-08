package MinHeap;

public class MinHeap<T extends Comparable<T>> {
    T datos[];
    int cont;

    public void insert(T elemento) {
        int aux;
        cont++;
        if (cont >= datos.length - 1) {
            expand();
        }
        datos[cont] = elemento;
        aux = cont;
        while (aux > 1 && datos[aux >> 1].compareTo(elemento) > 0) {
            datos[aux] = datos[aux >> 1];
            aux = aux >> 1;
        }

    }

    public T deleteMin() {
        T auxi = datos[1];
        datos[1] = datos[cont];
        cont--;
        int aux = 1;
        // aux <<1 es el hijo izquierdo y aux <<1+1 es el hijo derecho
        while (aux << 1 <= cont) {
            if (aux << 1 + 1 <= cont) {
                if (datos[aux << 1].compareTo(datos[aux << 1 + 1]) < 0) {
                    if (datos[aux].compareTo(datos[aux << 1]) > 0) {
                        T aux2 = datos[aux];
                        datos[aux] = datos[aux << 1];
                        datos[aux << 1] = aux2;
                        aux = aux << 1;
                    } else {
                        break;
                    }
                } else {
                    if (datos[aux].compareTo(datos[aux << 1 + 1]) > 0) {
                        T aux2 = datos[aux];
                        datos[aux] = datos[aux << 1 + 1];
                        datos[aux << 1 + 1] = aux2;
                        aux = aux << 1 + 1;
                    } else {
                        break;
                    }
                }
            } else {
                if (datos[aux].compareTo(datos[aux << 1]) > 0) {
                    T aux2 = datos[aux];
                    datos[aux] = datos[aux << 1];
                    datos[aux << 1] = aux2;
                    aux = aux << 1;
                } else {
                    break;
                }
            }
        }
        return auxi;
    }

}
