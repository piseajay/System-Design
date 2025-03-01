public class RemoveDuplicateFromSortedArrayII {

    public static void main(String[] args) {

        int result = removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
        System.out.println("result = " + result);
    }

    public static int removeDuplicates(int[] nums) {

        int i = 0;

        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }

        return i;
    }
}
