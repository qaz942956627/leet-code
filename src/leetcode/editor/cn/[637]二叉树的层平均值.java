package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<Double> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
//            LinkedList<Integer> values = new LinkedList<>();
            double sum = 0d;
//            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
//                values.add( node.val);
                sum += node.val;
//                count++;
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
//            Double avg = values.stream().collect(Collectors.averagingDouble(Double::valueOf));
            res.add(sum/size);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
