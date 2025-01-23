import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {

        reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }

    public static void reverseString(char[] s) {

        if (s.length != 1) {

            int left = 0;
            int right = s.length - 1;

            while (left < right) {
                char leftChar = s[left];
                s[left] = s[right];
                s[right] = leftChar;
                left++;
                right--;
            }
            System.out.println(Arrays.toString(s));
        }
    }
}
