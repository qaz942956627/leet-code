package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution111 {
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left==null&& node.right==null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // TreeNode treeNode = new TreeNode(2);
        // treeNode.right = new TreeNode(3);
        // treeNode.right.right = new TreeNode(4);
        // treeNode.right.right.right = new TreeNode(5);
        // treeNode.right.right.right.right = new TreeNode(6);
        // solution.minDepth(treeNode);
    }



}
//leetcode submit region end(Prohibit modification and deletion)
