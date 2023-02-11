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
class Solution114 {
    /**
     * 递归方法的定义: 当传入节点向右展开成一条直线
     * 让root的左边等于null
     * 让root的右边等于左边展开的结果
     * 让root原来的右节点展开的结果 放到左边展开的结果的最右边
     *
     * @param root 根
     */
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        flatten(root.left);

        TreeNode right = root.right;
        flatten(root.right);

        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

    }


}
//leetcode submit region end(Prohibit modification and deletion)
