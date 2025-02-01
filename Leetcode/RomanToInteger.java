import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        Map<Character, Integer> valueMap = new HashMap<>();
        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);

        int total = 0;
        int lastIndexValue = 0;

        for (char c : s.toCharArray()) {
            Integer currIndexValue = valueMap.get(c);
            if (lastIndexValue < currIndexValue) {
                currIndexValue = currIndexValue - (2 * lastIndexValue);
            }
            total += currIndexValue;
            lastIndexValue = currIndexValue;
        }
        return total;
    }
}
