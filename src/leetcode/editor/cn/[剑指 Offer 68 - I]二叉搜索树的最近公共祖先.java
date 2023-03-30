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
class Solution88_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        traverse(root, p, q);
        return result;

    }

    boolean res = false;
    TreeNode result;
    void traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (res||root == null) {
            return;
        }
        traverse(root.left, p, q);
        traverse(root.right, p, q);

        if (hasPQ(root, p, q)) {
            result = root;
            res = true;
        }
    }

    private boolean hasPQ(TreeNode root, TreeNode p, TreeNode q) {

        return traverse(root, p, q, false, false,false);
    }

    boolean traverse(TreeNode root, TreeNode p, TreeNode q,boolean hasP,boolean hasQ,Boolean res) {
        if (root == null) {
            return res;
        }
        if (hasP || root.val == p.val) {
            hasP = true;
        }

        if (hasQ || root.val == q.val) {
            hasQ = true;
        }
        if (hasP && hasQ) {
            res = true;
            return true;
        }
        traverse(root.left, p, q,hasP,hasQ,res);
        traverse(root.right, p, q,hasP,hasQ,res);
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
