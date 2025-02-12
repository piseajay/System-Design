public class SubArrayProductLessThanK {

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k == 0) {
            return k;
        }

        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            int product = 1;
            int start = i;
            int end = nums.length - 1;

            while (start <= end && product < k) {
                if (product * nums[start] < k) {
                    product *= nums[start];
                    result++;
                } else {
                    break;
                }
                start++;
            }
        }
        return result;
    }
}
