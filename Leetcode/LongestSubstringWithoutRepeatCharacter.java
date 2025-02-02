import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatCharacter {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> hash = new HashMap<>();
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (hash.containsKey(current)) {
                start = Math.max(start, hash.get(current) + 1);
            }
            hash.put(current, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
