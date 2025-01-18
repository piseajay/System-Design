import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ValidPalindrome {

    public static void main(String[] args) {

        String str = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sbr.append(c);
            }
        }
        return sbr.toString().contentEquals(sbr.reverse());
    }
}
