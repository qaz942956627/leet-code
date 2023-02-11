package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution1302 {

    int maxLevel = -1;
    int depth = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {

        dfs(root);
        return sum;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (depth > maxLevel) {
            maxLevel = depth;
            sum = root.val;
        } else if (depth == maxLevel) {
            if (root.left == null && root.right == null) {
                sum += root.val;
            }
        }
        dfs(root.left);
        dfs(root.right);
        depth--;

    }


    public int deepestLeavesSumBfs(TreeNode root) {
        int res = 0;

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            res = 0;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    res += node.val;
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
