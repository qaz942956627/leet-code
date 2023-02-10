package leetcode.editor.cn;
// leetcode submit region begin(Prohibit modification and deletion)

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
class Solution110 {

    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        traverse(root);

        return res;
    }

    void traverse(TreeNode root) {
        if (!res || root == null) {
            return;
        }
        boolean balanced = isBalanced(root.left, root.right);
        if (!balanced) {
            res = false;
        }
        traverse(root.left);

        traverse(root.right);

    }

    public boolean isBalanced(TreeNode left, TreeNode right) {

        int leftHeight = maxHeight(left);
        int rightHeight = maxHeight(right);
        return Math.abs(leftHeight - rightHeight) < 2;
    }


    private int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
