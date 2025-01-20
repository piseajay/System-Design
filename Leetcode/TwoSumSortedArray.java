import java.util.Arrays;

public class TwoSumSortedArray {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if ((numbers[left] + numbers[right]) > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
