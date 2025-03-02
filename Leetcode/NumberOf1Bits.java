package Leetcode;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(15));
    }

    public static int hammingWeight(int n) {

        int countOf1 = 1;

        while (n > 1) {
            if (n % 2 == 1) {
                countOf1 += 1;
            }
            n = n / 2;
        }
        return countOf1;
    }
}
