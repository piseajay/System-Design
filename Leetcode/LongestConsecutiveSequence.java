import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{0, 0}));
    }

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, 1);
        }

        int longestConsecutive = 1;
        int currCount = 1;
        List<Integer> keys = new ArrayList<>(map.keySet());

        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i) == keys.get(i - 1) + 1) {
                currCount++;
            } else {
                currCount = 1;
            }
            longestConsecutive = Math.max(longestConsecutive, currCount);
        }
        return longestConsecutive;
    }
}
