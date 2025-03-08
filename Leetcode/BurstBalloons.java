package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class BurstBalloons {

    public static void main(String[] args) {

        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }

    public static int findMinArrowShots(int[][] points) {

        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int count = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            count++;
            arrowPos = points[i][1];
        }
        return count;
    }
}
