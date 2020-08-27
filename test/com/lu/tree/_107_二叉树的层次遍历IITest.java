package com.lu.tree;

import org.junit.jupiter.api.Test;

class _107_二叉树的层次遍历IITest {

    @Test
    void levelOrderBottom() {
        _107_二叉树的层次遍历II v = new _107_二叉树的层次遍历II();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        v.levelOrderBottom(node);
    }
}