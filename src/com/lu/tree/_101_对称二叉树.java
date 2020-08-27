package com.lu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class _101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null) {
                return false;
            }

            if (l.val != r.val) {
                return false;
            }
            queue.add(l.left);
            queue.add(r.right);
            queue.add(l.right);
            queue.add(r.left);
        }
        return true;
    }

    private boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }

        if (l.val != r.val) {
            return false;
        }

        return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }



}
