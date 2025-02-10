public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {

        int slength = s.length();
        int tlength = t.length();

        if (slength != tlength) {
            return false;
        }

        int[] alphabetArray = new int[26];
        for (int i = 0; i < slength; i++) {
            alphabetArray[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < tlength; i++) {
            alphabetArray[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabetArray[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
