public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("y"));
    }

    public static int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return s.trim().split(" ")[words.length - 1].length();
    }
}
