package Leetcode;

public class MinimumBitFlipsToConvertNumber {

    public static void main(String[] args) {
        System.out.println(minBitFlips(3, 4));
    }

    public static int minBitFlips(int start, int goal) {

        int res = start ^ goal;

        int flips = 0;

        while (res > 1) {
            if (res % 2 == 1) {
                flips += 1;
            }
            res = res >> 1;
        }
        if (res == 1) {
            flips += 1;
        }
        return flips;
    }
}
