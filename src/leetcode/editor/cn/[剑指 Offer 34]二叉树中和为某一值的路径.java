package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
class SolutionJ34 {

    int target;

    int sum = 0;

    List<List<Integer>> res;

    LinkedList<Integer> list;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();

        this.target = target;
        this.list = new LinkedList<>();
        dfs(root);

        return res;

    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        sum += root.val;
        this.list.add(root.val);

        if (root.left == null && root.right == null && this.sum == this.target) {
            res.add(new LinkedList<>(list));
        }

        dfs(root.left);
        dfs(root.right);
        sum -= root.val;
        list.removeLast();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
