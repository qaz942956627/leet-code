package leetcode.editor.cn;


import leetcode.editor.cn.printer.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
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
class SolutionJ55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    int height(TreeNode root) {
        if (root==null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }



    public static void main(String[] args) {
        // TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,null,6,7,null,null,null,null,8});
        // BinaryTrees.println(treeNode);
        // Solution solution = new Solution();
        // System.out.println(solution.isBalanced(treeNode));

    }


}
//leetcode submit region end(Prohibit modification and deletion)
