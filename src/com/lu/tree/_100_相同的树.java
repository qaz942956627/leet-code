package com.lu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class _100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode p1 = queue.poll();
            TreeNode q1 = queue.poll();

            if (p1==null && q1==null) {
                return true;
            }
            if (p1==null || q1==null) {
                return false;
            }

            if (q1.val != p1.val) {
                continue;
            }
            queue.offer(p1.left);
            queue.offer(q1.left);
            queue.offer(p1.right);
            queue.offer(q1.right);
        }
        return true;
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
