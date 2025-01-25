import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println((missingNumber(new int[]{0, 1, 2})));
    }

    public static int missingNumber(int[] nums) {
        int sum = 0;
        int expectedSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        for (int i = 1; i <= nums.length; i++) {
            expectedSum += i;
        }

        return expectedSum - sum;
    }
}
