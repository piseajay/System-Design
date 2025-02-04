import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //nums1 = [1,2,3,0,0,0], m = 3,
        //nums2 = [2,5,6], n = 3

        int last = nums1.length - 1;

        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[last] = nums1[m - 1];
                m -= 1;
            } else {
                nums1[last] = nums2[n - 1];
                n -= 1;
            }
            last -= 1;
        }

        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n -= 1;
            last -= 1;
        }

        System.out.println(Arrays.toString(nums1));
    }
}
