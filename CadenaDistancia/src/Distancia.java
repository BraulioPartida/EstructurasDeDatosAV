public class Distancia {
    // Create a method to calculate the minimun distance between two strings
    // recursively without using a library
    public static int distancia(String a, String b) {
        // If the first string is empty, the distance is the length of the second string
        if (a.length() == 0) {
            return b.length();
        }
        // If the second string is empty, the distance is the length of the first string
        if (b.length() == 0) {
            return a.length();
        }
        // If the last characters of both strings are the same, the distance is the same
        // as the distance of the rest of the strings
        if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
            return distancia(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1));
        }
        // If the last characters of both strings are different, the distance is the
        // minimun between the distance of the rest of the strings plus one
        // (because we are adding a character) and the distance of the rest of the
        // strings plus one (because we are removing a character)
        return 1 + Math.min(distancia(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)),
                distancia(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)));
    }

    public static void main(String[] args) {
        System.out.println(distancia("casa", "calle"));
    }

}
