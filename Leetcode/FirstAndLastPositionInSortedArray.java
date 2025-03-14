package Leetcode;

public class FirstAndLastPositionInSortedArray {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] res = searchRange(nums, target);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] searchRange(int[] nums, int target) {

        int low = firstOccurrence(nums, target);

        if (low == -1) {
            return new int[]{-1, -1};
        }

        int upp = lastOccurrence(nums, target);

        return new int[]{low, upp};
    }

    public static int firstOccurrence(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOccurrence(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
