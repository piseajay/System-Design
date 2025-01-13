public class IncreasingTriplet {

    public static void main(String[] args) {

        System.out.println(increasingTriplet(new int[]{5, 4, 3, 4, 3}));
    }

    public static boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > second) {
                return true;
            }

            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second && nums[i] > first) {
                second = nums[i];
            }
        }
        return false;
    }
}
