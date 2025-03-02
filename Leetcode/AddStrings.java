package Leetcode;

public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("505", "105"));
    }

    public static String addStrings(String num1, String num2) {

        StringBuilder res = new StringBuilder();

        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        int sum;

        while (l1 >= 0 || l2 >= 0 || carry > 0) {

            int digit1 = (l1 >= 0) ? num1.charAt(l1--) - '0' : 0;
            int digit2 = (l2 >= 0) ? num2.charAt(l2--) - '0' : 0;

            sum = digit1 + digit2 + carry;

            res.append(sum % 10);
            carry = sum / 10;
        }
        return res.reverse().toString();
    }
}
