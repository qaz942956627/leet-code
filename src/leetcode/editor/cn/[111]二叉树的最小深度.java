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

    int minDepth = Integer.MAX_VALUE;
    int depth = 0;

    /**
     * 递归解法 在进入子节点的时候深度+1 在离开节点的时候深度-1
     * 在离开叶子节点的时候判断最小深度
     *
     * @param root 根
     * @return int
     */
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }

        traverse(root);

        return minDepth;
    }

    void traverse(TreeNode root) {
        if (root==null) {
            return;
        }
        depth++;
        traverse(root.left);
        traverse(root.right);
        // 如果离开的是一个根节点 那么更新一下最小深度
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depth);
        }
        depth--;
    }

    public int minDepth1(TreeNode root) {
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
