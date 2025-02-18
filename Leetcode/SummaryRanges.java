import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }

    public static List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                if (start != end) {
                    result.add(start + "->" + end);
                } else {
                    result.add(String.valueOf(start));
                }
                start = nums[i];
                end = nums[i];
            }
        }

        if (start != end) {
            result.add(start + "->" + end);
        } else {
            result.add(String.valueOf(start));
        }
        return result;
    }
}
