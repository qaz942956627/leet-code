package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;

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
class Solution144 {

    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {

        res = new LinkedList<>();
        trasever(root);
        return res;
    }

    void trasever(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        trasever(root.left);
        trasever(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
