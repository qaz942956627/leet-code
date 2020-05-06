package com.lu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class _226_翻转二叉树 {

    /**
     * 先序遍历
     * 置换左右的代码位置不同,分别是三种遍历情况
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    /**
     * 中序遍历
     * 这种情况结果是不正确的  因为先只换了左边 然后又要换右边 有的没交换到 有的重复交换
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree2(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree2(root.right);
        return root;
    }
    /**
     * 中序遍历
     * 需要两次调用的方法都是传入left节点 这样第一次翻转和第二次翻转就是正确的
     */
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree4(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree4(root.left);
        return root;
    }
    /**
     * 后序遍历
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree3(root.left);
        invertTree3(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
    public TreeNode invertTree1(TreeNode root) {
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
