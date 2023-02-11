package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class Solution515 {

    int depth = 0;
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();

        dfs(root);
        return res;

    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(root.val);
        } else {
            Integer maxValue = res.get(depth);
            if (maxValue<root.val) {
                res.set(depth, root.val);
            }
        }
        depth++;
        dfs(root.left);
        dfs(root.right);
        depth--;
    }

    public List<Integer> largestValuesBfs(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                maxVal = Math.max(maxVal, node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            res.add(maxVal);
        }

        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
