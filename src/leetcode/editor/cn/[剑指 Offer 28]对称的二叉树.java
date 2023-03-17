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
class SolutionJ28 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }


        return traverse(root.left, root.right);
    }

    boolean traverse(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left==null||right==null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return traverse(left.left, right.right) && traverse(left.right, right.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
