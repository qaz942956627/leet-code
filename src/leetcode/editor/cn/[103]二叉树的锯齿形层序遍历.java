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
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = true;

        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (flag) {
                    level.addLast(treeNode.val);
                } else {
                    level.addFirst(treeNode.val);
                }

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

            }
            flag = !flag;
            res.add(level);

        }
        return res;

    }

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // TreeNode treeNode = new TreeNode(3);
        // treeNode.left = new TreeNode(9);
        // treeNode.right = new TreeNode(20);
        // treeNode.right.left = new TreeNode(15);
        // treeNode.right.right = new TreeNode(7);
        // solution.zigzagLevelOrder(treeNode);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
