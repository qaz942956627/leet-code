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
class SolutionJ27 {
    public TreeNode mirrorTree(TreeNode root) {
        traverse(root);

        return root;
    }

    void traverse(TreeNode root) {
        if (root==null) {
            return;
        }

        traverse(root.left);
        traverse(root.right);
        TreeNode temp = root.left;

        root.left = root.right;
        root.right = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
