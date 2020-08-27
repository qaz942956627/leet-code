package com.lu.tree;

import java.util.*;

public class _107_二叉树的层次遍历II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            //每次队列中的数据都是一层,把每一层的值放到list中,把左右节点放到队列中
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            //使用linkList每次add都放在第一个就不需要翻转数组
            result.add(0,list);
        }
        return result;
    }

}

