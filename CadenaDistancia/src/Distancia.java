public class Distancia {
    private static int x = 0;

    public static int distancia(String a, String b) {
        x = x + 1;

        if (a.length() == 0) {
            return b.length();
        }

        if (b.length() == 0) {
            return a.length();
        }

        if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
            return distancia(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1));
        }

        return 1 + Math.min(distancia(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)),
                distancia(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)));
    }

    public static String randomString(int n) {
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {
            text.append((char) (Math.random() * 100 + 1));

        }

        return text.toString();
    }

    public static void main(String[] args) {
        System.out.println(distancia("fernando", "ernando"));

        for (int i = 0; i < 20; i++) {
            String input = randomString(i);
            String input2 = randomString(i);
            distancia(input, input2);
            System.out.println((int) Math.pow(i, 3) + " " + x);
        }

    }

}
