package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SolutionJ54 {

    Integer res;
    int rank = 0;
    public int kthLargest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }

    void traverse(TreeNode root,Integer k) {

        if (root == null) {
            return;
        }
        traverse(root.right,k);
        rank++;
        if (k==rank) {
            res = root.val;
            return;
        }

        traverse(root.left,k);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
