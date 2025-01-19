public class IsSubsequence {

    public static void main(String[] args) {

        System.out.println(isSubsequence("bb", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        for (int i = 0; i < s.length(); i++) {

            int index = t.indexOf(s.charAt(i));
            if (index == -1) return false;
            else {
                t = t.substring(index + 1);
            }
        }
        return true;
    }
}
