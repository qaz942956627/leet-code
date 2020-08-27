package com.lu.tree;

public class _110_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (height(root)==-1) {
            return false;
        }
        return true;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
