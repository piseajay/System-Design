public class UniqueCharsInString {

    public static void main(String[] args) {

        System.out.println(allCharsUnique("abcdefghijjjjjjjjjjjjjjklmnopa"));
    }

    public static boolean allCharsUnique(String str) {

        int[] alphabets = new int[26];

        if (str.length() > 26) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            alphabets[str.charAt(i) - 'a']++;
        }

        for (int alphabet : alphabets) {
            if (alphabet > 1) return false;
        }

        return true;
    }
}
