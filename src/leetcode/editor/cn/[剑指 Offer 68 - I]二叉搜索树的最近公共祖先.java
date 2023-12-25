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
class Solution68_1 {

    TreeNode parent = null;
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);
        return res;

    }

    void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return;
        }

        dfs(root.left, p, q);
        if (p.val == root.val) {
            parent = root;
        }
        if (parent != null) {
            parent = root;
        }
        if (q.val == root.val) {
            res = parent;
        }
        dfs(root.right, p, q);

    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
//        Solution solution = new Solution();
//        solution.lowestCommonAncestor(treeNode,new TreeNode(2),new TreeNode(8));

    }

}
//leetcode submit region end(Prohibit modification and deletion)
