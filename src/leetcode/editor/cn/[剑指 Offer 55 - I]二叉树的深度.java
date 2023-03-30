package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SolutionJ55_1 {

    int maxDepth = 0;
    int curDepth = 0;
    public int maxDepth(TreeNode root) {

        traverse(root);
        return maxDepth;
    }
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        curDepth++;
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, curDepth);
        }
        traverse(root.left);
        traverse(root.right);
        curDepth--;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
