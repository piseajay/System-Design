import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }

    public static boolean isIsomorphic(String s, String t) {

        Map<Character, Character> charMap = new HashMap<>();
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!charMap.containsKey(s.charAt(i))) {
                if (charMap.containsValue(t.charAt(i))) {
                    return false;
                }
                charMap.put(s.charAt(i), t.charAt(i));
            }
            sb1.append(charMap.get(s.charAt(i)));
        }
        return sb1.toString().equals(t);
    }
}
