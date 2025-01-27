public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int maxTotalWaterHold = 0;

        while (start < end) {
            int maxWaterHold;
            if (height[start] <= height[end]) {
                maxWaterHold = height[start] * (end - start);
                start++;
            } else {
                maxWaterHold = height[end] * (end - start);
                end--;
            }
            maxTotalWaterHold = Math.max(maxTotalWaterHold, maxWaterHold);
        }
        return maxTotalWaterHold;
    }
}
