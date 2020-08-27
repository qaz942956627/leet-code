package com.lu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class _111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        int depth = Integer.MAX_VALUE;
        if (root.left != null) {
            depth = Math.min(depth, minDepth(root.left));
        }

        if (root.right != null) {
            depth = Math.min(depth, minDepth(root.right));
        }
        return depth + 1;
    }

    public int minDepth1(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left==null || node.right == null) {
                    return depth +1;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}
