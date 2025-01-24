public class SingleNumber {

    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{4, 1, 5, 1, 5}));

        //System.out.println(4 ^ 5);
    }

    public static int singleNumber(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}