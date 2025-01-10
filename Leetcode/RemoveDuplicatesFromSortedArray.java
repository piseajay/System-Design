public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int result = removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println("result = " + result);
    }

    public static int removeDuplicates(int[] nums) {

        int uniqueIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                nums[++uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex;
    }
}
