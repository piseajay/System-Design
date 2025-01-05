public class TwiceNumeArray {

    public static void main(String[] args) {

        System.out.println(dominantIndex(new int[] {1,2,3,6}));
        System.out.println(dominantIndex(new int[] {0,0,0,1}));
        System.out.println(dominantIndex(new int[] {15,44,34,10}));
    }

    public static int dominantIndex(int[] nums) {
        {
            int largest = 0;
            int secondLargest = 0;
            int index = 0;
            for (int i = 0; i < nums.length; i++) {

                if (nums[i] > largest) {
                    secondLargest = largest;
                    largest = nums[i];
                    index = i;
                } else if (nums[i] > secondLargest) {
                    secondLargest = nums[i];
                }
            }
            return (largest >= (secondLargest * 2)) ? index : -1;
        }
    }
}