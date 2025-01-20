import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numCount.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int rem = target - nums[j];
            if (numCount.containsKey(rem) && numCount.get(rem) != j) {
                return new int[]{j, numCount.get(rem)};
            }
        }
        return null;
    }
}
