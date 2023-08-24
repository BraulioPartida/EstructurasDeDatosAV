public class Sorts {
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
                if (arr[j].compareTo(arr[j + 1]) > 0) {
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
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
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
            for (int j = i + 1; j < n; j++)
                if (arr[j].compareTo(arr[min_idx]) < 0)
                    min_idx = j;

            // Intercambiar el elemento mínimo encontrado con el primer elemento
            temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 5, 4, 3, 2, 1 };
        for (Integer integer : arr) {
            System.out.println(integer);
        }
        System.out.println("\n");
        quickSort(arr, 0, arr.length - 1);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }

}
