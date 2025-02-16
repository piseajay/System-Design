import java.util.Set;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
    }

    public static String simplifyPath(String path) {

        Set<Integer> set = new java.util.HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        set.remove(1);

        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.equals(".") && !part.isEmpty()) {
                stack.push(part);
            }
        }

        StringBuilder pathBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            pathBuilder.insert(0, "/" + stack.pop());
        }
        path = pathBuilder.toString();

        if (path.isEmpty()) {
            return "/";
        }
        return path;
    }
}
