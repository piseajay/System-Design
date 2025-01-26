public class NumMatchingSubsequence {
    public static void main(String[] args) {

        System.out.println(numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    }

    public static int numMatchingSubseq(String s, String[] words) {

        int numMatchingSubseq = 0;

        for (String word : words) {
            if (isSubsequence(word, s)) {
                numMatchingSubseq += 1;
            }
        }
        return numMatchingSubseq;
    }

    public static boolean isSubsequence(String s, String t) {

        for (int i = 0; i < s.length(); i++) {

            int index = t.indexOf(s.charAt(i));
            if (index == -1) return false;
            else {
                t = t.substring(index + 1);
            }
        }
        return true;
    }
}
