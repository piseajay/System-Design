package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayRank {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12})));
    }

    public static int[] arrayRankTransform(int[] arr) {

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < sorted.length; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
