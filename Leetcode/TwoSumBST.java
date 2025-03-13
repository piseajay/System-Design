package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
        TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(3));
        System.out.println(twoSumBSTs(root1, root2, 6));
    }

    static List<Integer> elements1 = new ArrayList<>();
    static List<Integer> elements2 = new ArrayList<>();


    public static boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        preOrderTraversal1(root1);
        preOrderTraversal2(root2);

        for (int num : elements1) {
            if (elements2.contains(target - num)) {
                return true;
            }
        }
        return false;
    }

    public static void preOrderTraversal1(TreeNode root) {

        if (root == null) {
            return;
        }

        elements1.add(root.val);
        preOrderTraversal1(root.left);
        preOrderTraversal1(root.right);
    }

    public static void preOrderTraversal2(TreeNode root) {

        if (root == null) {
            return;
        }

        elements2.add(root.val);
        preOrderTraversal2(root.left);
        preOrderTraversal2(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
