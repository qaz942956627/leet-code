package leetcode.editor.cn;

import java.util.LinkedList;
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

}