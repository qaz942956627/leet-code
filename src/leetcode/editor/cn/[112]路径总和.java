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
class Solution112 {

    int sum = 0;

    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);

        return res;
    }

    void traverse(TreeNode root, int targetSum) {
        if (res || root == null) {
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null ) {

            if (sum == targetSum) {
                res = true;
            }
        }
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        sum -= root.val;

    }




}
//leetcode submit region end(Prohibit modification and deletion)
