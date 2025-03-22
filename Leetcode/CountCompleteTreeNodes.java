package Leetcode;

public class CountCompleteTreeNodes {

    static int nodes = 0;

    public static void main(String[] args) {
        System.out.println(countNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))));
    }

    public static int countNodes(TreeNode root) {
        count(root);
        return nodes;
    }

    public static void count(TreeNode root) {

        if (root == null) {
            return;
        }
        nodes += 1;
        count(root.left);
        count(root.right);
    }
}
