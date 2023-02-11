package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

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
class Solution112 {


    /**
     * 动规解法
     *
     * @param root      根
     * @param targetSum 目标和
     * @return boolean
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        // base case
        if (root == null) {
            return false;
        }
        // 达到根节点判断一下当前值是不是等于想要的值
        if (root.left == null && root.right == null) {

            if (root.val == targetSum) {
                return true;
            }
        }

        // 继续找左子树或者右子树有没有路径和为targetSum - 当前节点值的路径
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    int sum = 0;

    boolean res = false;

    /**
     * 遍历解法
     *
     * @param root      根
     * @param targetSum 目标和
     * @return boolean
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        traverse(root, targetSum);

        return res;
    }

    void traverse(TreeNode root, int targetSum) {
        if (res || root == null) {
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {

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
