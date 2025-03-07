package Leetcode;

import java.util.Arrays;

public class InsertIntervals {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{2, 5};
        int[][] res = insert(intervals, newInterval);
        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int[][] res = new int[n + 1][2];
        int i = 0;
        int index = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res[index++] = intervals[i++];
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res[index++] = newInterval;
        while (i < n) {
            res[index++] = intervals[i++];
        }
        return Arrays.copyOf(res, index);
    }
}
