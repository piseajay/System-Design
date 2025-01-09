import java.util.Arrays;

public class MajorityElement {

    public static void main(String[] args) {

        System.out.println(majority(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majority(int[] nums) {

        Arrays.sort(nums);
        System.out.println(nums.length / 2);
        return nums[nums.length / 2];
    }
}
