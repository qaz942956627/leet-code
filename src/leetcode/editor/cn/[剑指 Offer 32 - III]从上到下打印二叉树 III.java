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
 *     TreeNode(int x) { val = x; }
 * }
 */
class SolutionJ32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean addFirst = false;

        while (!queue.isEmpty()) {

            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();


            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (addFirst) {
                    list.addFirst(poll.val);
                } else {

                    list.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }

            }
            addFirst = !addFirst;
            res.add(list);

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
