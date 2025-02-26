package Leetcode;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
    }

    public static String mergeAlternately(String word1, String word2) {

        StringBuilder sbr = new StringBuilder();
        int word1Length = word1.length();
        int word2Length = word2.length();

        int min = Math.min(word1Length, word2Length);

        for (int i = 0; i < min; i++) {
            sbr.append(word1.charAt(i)).append(word2.charAt(i));
        }

        sbr.append((word1Length > word2Length ? word1.substring(min, word1Length) : word2.substring(min, word2Length)));

        return sbr.toString();
    }
}
