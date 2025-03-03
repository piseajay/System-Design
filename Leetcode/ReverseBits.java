package Leetcode;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n >>= 1;
            result <<= 1;
            result |= bit;
        }
        return result;
    }
}
