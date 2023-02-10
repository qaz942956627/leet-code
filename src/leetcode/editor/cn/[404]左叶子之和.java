package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {

        traverse(root);
        return sum;
    }

    int sum = 0;
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        if (left != null) {
            if (left.left == null && left.right == null) {
                sum += left.val;
            }
        }
        traverse(left);

        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
