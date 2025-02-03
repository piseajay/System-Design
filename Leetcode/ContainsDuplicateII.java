import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        boolean isDuplicate = false;
        
        Map<Integer, Integer> numIndexString = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIndexString.containsKey(nums[i]) &&
                    (Math.abs(i - numIndexString.get(nums[i])) <= k)) {
                isDuplicate = true;
            } else {
                numIndexString.put(nums[i], i);
            }
        }
        return isDuplicate;
    }
}
