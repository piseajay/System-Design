import java.util.Arrays;

public class ProductOfArrayExceptItselt {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 4, 0})));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int totalProduct = 1;
        int countOfZeroes = 0;

        if (nums.length == 2) {
            int first = nums[0];
            nums[0] = nums[1];
            nums[1] = first;
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0)
                totalProduct = totalProduct * nums[i];
            else
                countOfZeroes++;
        }

        if (countOfZeroes > 1) {
            Arrays.fill(nums, 0);
            return nums;
        }

        if (countOfZeroes == 1) {
            for (int i = 0; i < result.length; i++) {
                if (nums[i] == 0) {
                    result[i] = totalProduct;
                }
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                result[i] = totalProduct / nums[i];
            }
        }

        return result;
    }
}
