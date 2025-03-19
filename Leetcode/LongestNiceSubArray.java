package Leetcode;

public class LongestNiceSubArray {

    public static void main(String[] args) {
        System.out.println(longestNiceSubArray(new int[]{744437702, 379056602, 145555074, 392756761, 560864007, 934981918, 113312475, 1090, 16384, 33, 217313281, 117883195, 978927664}));
    }

    public static int longestNiceSubArray(int[] nums) {


        if (nums.length == 1) {
            return 1;
        }

        int niceSuarrayLength = 1;
        int currentLength = 1;
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if ((nums[i] & result) == 0) {
                result = nums[i] & result;
                currentLength++;
                niceSuarrayLength = Math.max(currentLength, niceSuarrayLength);
            } else {
                result = nums[i];
                currentLength = 1;
            }
        }
        return Math.max((niceSuarrayLength - 1), 1);
    }
}
