package Leetcode;

public class FindMinimumInRotatedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[low] <= nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }

            if (nums[low] <= nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
