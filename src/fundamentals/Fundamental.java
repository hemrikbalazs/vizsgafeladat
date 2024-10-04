package fundamentals;

/**
 * @author G
 */
public class Fundamental {

    public static void testMySolutions() {
        String invertedText = invertCase("AsewQzE"); // result: aSEWqZe
        System.out.println(invertedText);
        String ordered = orderChars("tewoiprvqcaaaporvwaourefal"); // aaaaaceefiloooppqrrrtuvvww
        System.out.println(ordered);
        int differentCharCount = countDifferentChars(ordered); // 14
        System.out.println("number of different chars:" + differentCharCount);
        boolean contains = containsCertainDigit(4567, 6); // true
        System.out.println("4567 contains 6: " + contains);
        String changed = replaceUnderscores(
                "Szer_tem___kihívásokat_és_a_vizsgákat.", "e", " ", "a", " ");// Szeretem a kihívásokat és a vizsgákat.
        System.out.println("A nap mondása: " + changed);

    }

    public static String invertCase(String original) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char nextChar = original.charAt(i);
            nextChar = invertCaseChar(nextChar);
            result.append(nextChar);
        }
        return result.toString();
    }

    private static char invertCaseChar(char nextChar) {
        if (Character.isLowerCase(nextChar)) {
            nextChar = Character.toUpperCase(nextChar);
        } else {
            nextChar = Character.toLowerCase(nextChar);
        }
        return nextChar;
    }

    public static String orderChars(String unorderedText) {
        char[] charArray = unorderedText.toCharArray();
        linearSortCharArray(charArray);
        String result = new String(charArray);
        return result;
    }

    private static void linearSortCharArray(char[] charArray) {
        int lastIndex = charArray.length - 1;
        char swap;
        for (int i = 0; i < lastIndex; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] > charArray[j]) {
                    swap = charArray[i];
                    charArray[i]= charArray[j];
                    charArray[j] = swap;
                }
            }
        }
    }

    public static int countDifferentChars(String ordered) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static boolean containsCertainDigit(int number, int digit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static String replaceUnderscores(
            String original, String... swapChars) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
