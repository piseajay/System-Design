public class MaximumSubarray {

    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {

        int currentSum = 0;
        int maxSum = nums[0];
        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum = currentSum + num;
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
