package com.lu.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _111_二叉树的最小深度Test {

    @Test
    void minDepth() {
        _111_二叉树的最小深度 v = new _111_二叉树的最小深度();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(v.minDepth(node));
    }
}