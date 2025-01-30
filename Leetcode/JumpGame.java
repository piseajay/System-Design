public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public static boolean canJump(int[] nums) {

        int startIndex = 0;
        int destination = nums.length - 1;

        for (int i = destination - 1; i >= 0; i--) {

            if ((nums[i]) + i >= destination) {
                destination = i;
            }
        }
        return destination == startIndex;
    }
}
