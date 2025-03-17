package Leetcode;

public class RangeSumOfBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        int rootVal = (low <= root.val && root.val <= high) ? root.val : 0;

        int leftVal = rangeSumBST(root.left, low, high);

        int rightVal = rangeSumBST(root.right, low, high);

        return rootVal + leftVal + rightVal;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}