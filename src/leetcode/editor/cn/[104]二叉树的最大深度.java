package leetcode.editor.cn;

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
class Solution104 {
    /**
     * 动规 当前节点的高度等于 左右子树更高的高度 +1
     *
     * @param root 根
     * @return int
     */
    public int maxDepth(TreeNode root) {

        if (root==null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    /**
     * 层序遍历
     *
     * @param root 根
     * @return int
     */
    public int maxDepth1(TreeNode root) {

        int depth = 0;

        if (root == null) {
            return depth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            depth++;

        }
        return depth;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
