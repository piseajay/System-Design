import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int result = removeElement(nums, val);
        System.out.println("result = " + result);
    }

    public static int removeElement(int[] nums, int val) {

        int right = nums.length - 1;
        int left = 0;
        int count = 0;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = val;
                right--;
                count++;
            } else {
                left++;
            }
        }
        return nums.length - count;
    }
}
