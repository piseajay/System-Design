public class AddedLetterInString {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        char result = findTheDifference(s, t);
        System.out.println("result = " + result);
    }

    public static char findTheDifference(String s, String t) {

        int[] letters = new int[26];

        for (char c : t.toCharArray()) {
            letters[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            letters[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] == 1) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }
}
