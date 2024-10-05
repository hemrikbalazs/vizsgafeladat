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
        boolean contains = containsCertainDigit(4567, 5); // true
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
                    charArray[i] = charArray[j];
                    charArray[j] = swap;
                }
            }
        }
    }

    public static int countDifferentChars(String ordered) {
        int count = 0;
        if (ordered.length() > 0) {
            count = 1;
            for (int i = 1; i < ordered.length(); i++) {
                if (ordered.charAt(i) != ordered.charAt(i - 1)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean containsCertainDigit(int number, int digit) {
        boolean run = true;
        while (run && number > 0) {
            run = !checkLastDigit(number, digit);
            number = number / 10;
        }
        return !run;
    }

    private static boolean checkLastDigit(int number, int digit) {
        number -= digit;
        return number % 10 == 0;
    }

    public static String replaceUnderscores(
            String original, String... swapChars) {
        int index = 0;
        int length = swapChars.length;
        while (original.contains("_")) {
            original = original.replaceFirst("_", swapChars[index]);
            index += calculateIncrement(index, length);
        }
        return original;
    }

    private static int calculateIncrement(int index, int length) {
        int steps = length - 1 - index;
        return (steps -1) >>> 31 ^ 1;
    }
}
