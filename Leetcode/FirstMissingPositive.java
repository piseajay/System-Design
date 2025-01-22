import java.util.Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {

        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 3, 11, 12, 1, 2, 4}));
    }

    public static int firstMissingPositive(int[] nums) {

        int smallestMissingInt = 1;

        Arrays.sort(nums);

        for (int num : nums) {
            if (num == smallestMissingInt) {
                smallestMissingInt += 1;
            }
        }
        return smallestMissingInt;
    }
}
