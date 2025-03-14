package Leetcode;

public class LowerBound {

    public static void main(String[] args) {

        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;

        System.out.println(findFloor(arr, x));
    }

    static int findFloor(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;
        int ans = 0;

        while (low <= high) {

            int mid = (high + low) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
