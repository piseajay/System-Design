import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (Objects.isNull(charMap.get(c)) || charMap.get(c) == 0) {
                return false;
            }
            charMap.put(c, charMap.get(c) - 1);
        }
        return true;
    }
}
