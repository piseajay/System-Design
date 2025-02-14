public class JumpGameII {

    public static void main(String[] args) {

        int[] nums = {2, 3, 0, 1, 4};
        int minJumps = jump(nums);
        System.out.println("minJumps = " + minJumps);
    }

    public static int jump(int[] nums) {

        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }
}
