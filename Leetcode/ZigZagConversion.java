public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;
        StringBuilder result = new StringBuilder();
        int increment = 2 * (numRows - 1);

        for (int row = 0; row < numRows; row++) {

            for (int i = row; i < s.length(); i = i + increment) {
                result.append(s.charAt(i));

                if (row > 0 && row < numRows - 1 && (i + increment - 2 * row) < s.length()) {
                    result.append(s.charAt(i + increment - 2 * row));
                }
            }
        }
        return result.toString();
    }
}
