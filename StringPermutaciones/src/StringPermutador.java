public class StringPermutador {
    private static int x = 0;

    public static int calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int factorial = 1;
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }

    public static int calcularFactorialRecur(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * calcularFactorialRecur(n - 1);
        }

    }

    public static void permute(String str, int left, int right) {
        if (left == right) {
            return;
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                permute(str, left + 1, right);
                str = swap(str, left, i); // backtrack
                x = x + 1;
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    public static String randomString(int n) {
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {
            text.append((char) (Math.random() * 100 + 1));

        }

        return text.toString();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            String input = randomString(i);
            permute(input, 0, input.length() - 1);
            System.out.println(calcularFactorial(6) + " " + x);
            System.out.println(calcularFactorialRecur(6));
        }
    }
}
https://docs.google.com/document/d/1QIAmFyMnxKG_ONs7O_rlNLBGI4kleqmaXwIQrD47xVU/edit?usp=sharing
