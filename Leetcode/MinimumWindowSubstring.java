package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {

        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count++;
                }

                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minStart = left;
                    }

                    char leftChar = s.charAt(left);
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) + 1);
                        if (map.get(leftChar) > 0) {
                            count--;
                        }
                    }

                    left++;
                }
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
