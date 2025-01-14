import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        rotate(new int[]{-1, -100, 3, 99}, 2);
    }

    public static void rotate(int[] nums, int k) {

        if (nums.length < k) {
            k = k % nums.length;
        }

        int[] rotate = new int[k];

        for (int i = 0; i < k; i++) {
            rotate[k - i - 1] = nums[nums.length - i - 1];
        }

        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < rotate.length; i++) {
            nums[i] = rotate[i];
        }

        System.out.println(Arrays.toString(nums));
    }
}
