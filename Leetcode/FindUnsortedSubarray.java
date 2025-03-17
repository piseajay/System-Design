package Leetcode;

public class FindUnsortedSubarray {

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    public static int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        int start = -1;
        int end = -2;
        int min = nums[n - 1];
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[n - 1 - i] > min) {
                start = n - 1 - i;
            }
        }
        return end - start + 1;
    }
}
