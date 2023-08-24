public class InterseccionArray {
    private static int x = 0;

    public <T> int interseccion(T[] array1, T[] array2) {
        int cont = 0;
        for (T t : array2) {
            if (pertenece(array1, t)) {

            }

        }
        return cont;
    }

    public <T> boolean pertenece(T[] array, T elemento) {
        boolean b = false;
        for (T t : array) {
            if (elemento.equals(t)) {
                b = true;
            }
            x++;
        }
        return b;
    }

    public Integer[] randomArr(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        InterseccionArray ia = new InterseccionArray();
        for (int i = 0; i < 100; i++) {
            System.out.println((int) Math.pow(i, 2) + " " + (ia.interseccion(ia.randomArr(i), ia.randomArr(i)) + x));
        }
    }

}
