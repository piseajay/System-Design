import java.util.HashMap;
import java.util.Map;

public class CountPairsWithKDifference {

    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{1, 3}, 3));
    }

    public static int countKDifference(int[] nums, int k) {

        int result = 0;
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {

            boolean ifMatch = false;
            int min = num - k;
            int max = num + k;

            if (numCountMap.get(min) != null && numCountMap.get(min) != 0) {
                result += numCountMap.get(min);
                ifMatch = true;
            }

            if (numCountMap.get(max) != null && numCountMap.get(max) != 0) {
                result += numCountMap.get(max);
                ifMatch = true;
            }
            if (ifMatch) {
                numCountMap.put(num, numCountMap.get(num) - 1);
            }
        }
        return result;
    }
}
