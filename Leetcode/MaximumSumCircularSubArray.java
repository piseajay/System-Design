package Leetcode;

public class MaximumSumCircularSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
    }

    public static int maxSubarraySumCircular(int[] nums) {

        int maxSum = nums[0];
        int minSum = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);

            totalSum += nums[i];
        }

        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}
