public class ArregloDiv7 {

    // Una funcion que cuente la cantidad de pasos que le toma encontrar el
    // numero divisible entre 7 en un arreglo de enteros
    public static int div7(int[] arr) {
        int pasos = 0;
        int lugar;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 7 == 0) {
                lugar = i;
            }

            pasos++;
        }

        return pasos;
    }

    // Una funcion que de como return un arreglo de integers de tamaño aleatorio de
    // el tamaño indicado
    public static int[] randomArr(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {

            arr[i] = (int) (Math.random() * 100 + 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + div7(randomArr(i)));
        }
    }

}
