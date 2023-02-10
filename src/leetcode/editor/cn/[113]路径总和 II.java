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
class Solution113 {

    int sum = 0;

    LinkedList<Integer> sumPath;
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        sumPath = new LinkedList<>();
        res = new LinkedList<>();
        traverse(root, targetSum);

        return res;
    }

    void traverse(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        sum += root.val;
        sumPath.add(root.val);
        if (root.left == null && root.right == null) {
            if (target==sum) {
                res.add(sumPath);
            }
        }

        traverse(root.left, target);
        traverse(root.right, target);
        sum -= root.val;
        sumPath.removeLast();

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
