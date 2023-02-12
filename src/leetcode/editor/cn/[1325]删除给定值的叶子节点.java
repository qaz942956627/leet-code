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
class Solution1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root==null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // 在后续遍历的位置做删除操作 这样就可以做到当前节点的父节点也是target的时候后续的处理会删除掉父节点
        if (root.left == null && root.right == null) {
            if (root.val==target) {
                return null;
            }
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
