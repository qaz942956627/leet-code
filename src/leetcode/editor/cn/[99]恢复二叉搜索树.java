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
class Solution99 {

    TreeNode first = null, second = null;

    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {

        traverse(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void traverse(TreeNode root) {

        if (root == null) {
            return;
        }
        traverse(root.left);

        // 中序遍历 找到两个不符合中序遍历性质的节点

        if (preNode.val> root.val) {
            if (first == null) {
                // 第一个节点是preNode
                first = preNode;
            } else {
                // 第二个节点是root
                second = root;
            }
        }
        preNode = root;


        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
