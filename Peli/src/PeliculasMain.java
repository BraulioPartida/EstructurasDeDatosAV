import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PeliculasMain extends Sorts {
    private static int contb = 0, contq = 0, contm = 0, contiO = 0, conts = 0, contiM = 0;

    public static <T extends Comparable<T>> void quickSort(T[] datos, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particion(datos, inicio, fin);
            quickSort(datos, inicio, pivote - 1);
            quickSort(datos, pivote + 1, fin);
        }

    }

    public static <T extends Comparable<T>> int particion(T[] arr, int inicio, int fin) {
        T pivote = arr[fin];
        int i = (inicio - 1);

        for (int j = inicio; j < fin; j++) {
            contq++;
            if (arr[j].compareTo(pivote) < 0) {
                i++;

                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        T temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        T temp;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Si el elemento actual es mayor que el siguiente
                int h = arr[j].compareTo(arr[j + 1]);
                contb++;
                if (h > 0) {

                    // Intercambiar elementos
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Si no hubo intercambios en la pasada, entonces el arreglo ya está ordenado
            if (swapped == false)
                break;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int n = arr.length;
        int j;
        T key;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;

            // Mover elementos del arreglo que sean mayores que key, una posición adelante
            // de
            // su posición actual
            contiO++;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
                contiM++;

            }

            // Insertar key en su posición correcta
            arr[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        int n = arr.length;
        int min_idx;
        T temp;
        for (int i = 0; i < n - 1; i++) {
            // Encontrar el elemento mínimo en el arreglo
            min_idx = i;
            for (int j = i + 1; j < n; j++) {
                conts++;
                if (arr[j].compareTo(arr[min_idx]) < 0)
                    min_idx = j;
            }
            // Intercambiar el elemento mínimo encontrado con el primer elemento
            temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int inicio, int fin) {
        if (inicio < fin) {

            int mitad = (inicio + fin) / 2;

            // Ordernar la mitad izquierda y la mitad derecha del arreglo
            mergeSort(arr, inicio, mitad);
            mergeSort(arr, mitad + 1, fin);

            // Combina las mitades ordenadas
            merge(arr, inicio, mitad, fin);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int inicio, int mitad, int fin) {

        int tamañoIzq = mitad - inicio + 1;
        int tamañoDerecha = fin - mitad;

        T izquierda[] = (T[]) new Comparable[tamañoIzq];
        T derecha[] = (T[]) new Comparable[tamañoDerecha];

        for (int i = 0; i < tamañoIzq; ++i) {
            izquierda[i] = arr[inicio + i];
        }

        for (int j = 0; j < tamañoDerecha; ++j)
            derecha[j] = arr[mitad + 1 + j];

        int i = 0, j = 0;

        int k = inicio;
        while (i < tamañoIzq && j < tamañoDerecha) {
            contm++;
            if (izquierda[i].compareTo(derecha[j]) <= 0) {
                arr[k] = izquierda[i];
                i++;
            } else {
                arr[k] = derecha[j];
                j++;

            }
            k++;
        }

        while (i < tamañoIzq) {
            arr[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < tamañoDerecha) {
            arr[k] = derecha[j];
            j++;
            k++;
        }
    }

    public static Peliculas[] meter(int cantidad, ArrayList<Peliculas> pelis) {
        Peliculas[] arr = new Peliculas[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arr[i] = pelis.get(i);
        }

        return arr;
    }

    public static void invertirArreglo(Peliculas[] arr) {
        int n = arr.length;
        Peliculas temp;
        for (int i = 0; i < n / 2; i++) {
            temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    public static void ejercicio(Peliculas[] pelis, ArrayList<Peliculas> arr, int tipo) {
        for (int h = 0; h < 5; h++) {
            switch (h) {
                case 0:
                    System.out.println("\nBubble Sort");
                    break;
                case 1:
                    System.out.println("\nMerge Sort");
                    break;
                case 2:
                    System.out.println("\nQuick Sort");
                    break;
                case 3:
                    System.out.println("\nInsertion Sort");
                    break;
                case 4:
                    System.out.println("\nSelection Sort");
                    break;
            }

            for (int i = 0; i < 5; i++) {

                switch (i) {
                    case 0:
                        pelis = meter(100, arr);

                        break;

                    case 1:
                        pelis = meter(1000, arr);
                        break;

                    case 2:
                        pelis = meter(2500, arr);
                        break;

                    case 3:
                        pelis = meter(5000, arr);
                        break;

                    case 4:
                        pelis = meter(8000, arr);
                        break;
                }

                switch (tipo) {
                    case 1:
                        mergeSort(pelis, 0, pelis.length - 1);
                        break;
                    case 2:
                        invertirArreglo(pelis);
                        break;
                    case 3:
                        revolverArreglo(pelis);
                        break;
                }

                switch (h) {
                    case 0:
                        long startTime = System.currentTimeMillis();
                        bubbleSort(pelis);
                        long endTime = (System.currentTimeMillis() - startTime);
                        System.out.println(contb + " endetime: " + endTime);
                        break;
                    case 1:
                        startTime = System.currentTimeMillis();
                        mergeSort(pelis, 0, pelis.length - 1);
                        endTime = (System.currentTimeMillis() - startTime);
                        System.out.println(contm + " endetime: " + endTime);

                        break;
                    case 2:
                        startTime = System.currentTimeMillis();
                        quickSort(pelis, 0, pelis.length - 1);
                        endTime = (System.currentTimeMillis() - startTime);
                        System.out.println(contq + " endetime: " + endTime);

                        break;
                    case 3:
                        startTime = System.currentTimeMillis();
                        insertionSort(pelis);
                        endTime = (System.currentTimeMillis() - startTime);
                        System.out.println(contiO + " endetime: " + endTime);

                        break;
                    case 4:
                        startTime = System.currentTimeMillis();
                        selectionSort(pelis);
                        endTime = (System.currentTimeMillis() - startTime);
                        System.out.println(conts + " endetime: " + endTime);

                        break;
                }

            }
        }
    }

    public static void revolverArreglo(Peliculas[] arr) {
        int n = arr.length;
        Peliculas temp;
        for (int i = 0; i < n; i++) {
            int random = (int) (Math.random() * n);
            temp = arr[i];
            arr[i] = arr[random];
            arr[random] = temp;
        }
    }

    public static void main(String[] args) {
        try {
            ArrayList<Peliculas> arr = new ArrayList<>();
            Peliculas[] pelis = null;
            BufferedReader lector = new BufferedReader(new FileReader("Peli\\movie_titles2.txt"));
            String line;
            int clave, anio;
            String titulo;

            while ((line = lector.readLine()) != null) {
                line = lector.readLine();
                int lugar = line.indexOf(",");
                clave = Integer.parseInt(line.substring(0, lugar));
                int lugar2 = line.indexOf(",", lugar + 1);
                anio = Integer.parseInt(line.substring(lugar + 1, lugar2));
                titulo = line.substring(lugar2 + 1);
                arr.add(new Peliculas(clave, anio, titulo));
            }

            System.out.println("Ordenado ");
            ejercicio(pelis, arr, 1);

            System.out.println("\nInvertido ");
            ejercicio(pelis, arr, 2);

            System.out.println("\nRevuelto ");
            ejercicio(pelis, arr, 3);
            lector.close();

        }

        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
