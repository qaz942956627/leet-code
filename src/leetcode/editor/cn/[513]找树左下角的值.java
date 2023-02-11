package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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
class Solution513 {

    int depth = 0;
    int maxDepth = 0;

    int res = 0;


    /**
     * dfs
     *
     * @param root 根
     * @return int
     */
    public int findBottomLeftValue(TreeNode root) {

        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (depth>maxDepth) {
            maxDepth = depth;
            res = root.val;
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    /**
     * BFS
     *
     * @param root 根
     * @return int
     */
    public int findBottomLeftValueBfs(TreeNode root) {
        int res = 0;

        if (root==null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i==0) {
                    res = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
