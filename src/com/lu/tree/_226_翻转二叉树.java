package com.lu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class _226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        if (node == null) {
            return null;
        }

        while (!queue.isEmpty()) {

            node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
