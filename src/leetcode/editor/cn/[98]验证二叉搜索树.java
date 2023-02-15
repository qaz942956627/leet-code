package leetcode.editor.cn;

import leetcode.editor.cn.printer.BinaryTrees;
import leetcode.editor.cn.printer.PrintTreeNode;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.stream.Collectors;

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
class Solution98 {
    public boolean isValidBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        return isValidBST(root, null, null);
    }


    /**
     * 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
     * @param root
     * @param min
     * @param max
     * @return
     */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) {
            return true;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

//    public static void main(String[] args) {
//        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5, 4, 6, null, null, 3, 7});
//        BinaryTrees.println(treeNode);
//
//        Solution solution = new Solution();
//        System.out.println(solution.isValidBST(treeNode));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
