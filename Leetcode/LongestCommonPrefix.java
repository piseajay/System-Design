public class LongestCommonPrefix {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        String shortestString = "";
        String commonPrefix = "";

        if (strs.length == 0) {
            return commonPrefix;
        } else if (strs.length == 1) {
            return strs[0];
        }

        int shortestStringLength = 201;

        for (String str : strs) {
            if (str.length() < shortestStringLength) {
                shortestString = str;
                shortestStringLength = str.length();
            }
        }

        if (shortestString.isBlank()) {
            return "";
        }

        for (int i = 0; i < shortestString.length(); i++) {

            commonPrefix = shortestString.substring(0, i + 1);

            for (String str : strs) {
                if (!str.startsWith(commonPrefix)) {
                    return commonPrefix.length() > 1 ? commonPrefix.substring(0, commonPrefix.length() - 1) : "";
                }
            }
        }
        return commonPrefix;
    }
}
