package leetcode.editor.cn;

import leetcode.editor.cn.printer.BinaryTrees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lu
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }


    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static TreeNode buildTree(Integer[] numbers) {

        int length = numbers.length;
        if (length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(numbers[0]);

        // 当前操作数组索引  第0个元素已经当做root放进去了
        int curIndex = 1;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode preLevelNode = queue.poll();
                if (preLevelNode == null) {
//                    curIndex++;
//                    curIndex++;
                    continue;
                }
                if (curIndex >= length) {
                    return root;
                }

                Integer left = numbers[curIndex];
                if (left == null) {
                    queue.offer(null);
                } else {
                    TreeNode leftNode = new TreeNode(left);
                    preLevelNode.left = leftNode;
                    queue.offer(leftNode);
                }
                curIndex++;

                if (curIndex >= length) {
                    return root;
                }
                Integer right = numbers[curIndex];
                if (right == null) {
                    queue.offer(null);
                } else {
                    TreeNode rightNode = new TreeNode(right);
                    preLevelNode.right = rightNode;
                    queue.offer(rightNode);
                }
                curIndex++;

            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        root.right.right.right.right = new TreeNode(40);

        Integer[] numbers = {3,9,20,null,null,15,7,1,null,2,3,4};

        TreeNode buildTreeNode = TreeNode.buildTree(numbers);
//        BinaryTrees.println(root);
        BinaryTrees.println(buildTreeNode);


    }

}