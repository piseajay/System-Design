package Leetcode;

public class Seats {

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0}));
    }

    public static int maxDistToClosest(int[] seats) {

        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                prev = i;
            }
            left[i] = prev;
        }

        prev = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                prev = i;
            }
            right[i] = prev;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                res = Math.max(res, Math.min(i - left[i], right[i] - i));
            }
        }

        return res;
    }
}
