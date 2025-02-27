package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (current[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], current[1]);
            } else {
                result.add(prev);
                prev = current;
            }
        }
        result.add(prev);
        return result.toArray(new int[result.size()][]);
    }
}
