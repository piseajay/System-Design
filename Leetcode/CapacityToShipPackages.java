package Leetcode;

public class CapacityToShipPackages {

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public static int shipWithinDays(int[] weights, int days) {

        int low = Integer.MIN_VALUE;
        int high = 0;
        int leastCapacity = Integer.MAX_VALUE;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low <= high) {

            int mid = (low + high) / 2;
            int currDays = minDays(weights, mid);
            if (currDays <= days) {
                leastCapacity = Math.min(leastCapacity, currDays);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int minDays(int[] weights, int capacity) {

        int load = 0;
        int days = 1;

        for (int weight : weights) {
            if (load + weight > capacity) {
                days += 1;
                load = 0;
            }
            load += weight;
        }
        return days;
    }
}
