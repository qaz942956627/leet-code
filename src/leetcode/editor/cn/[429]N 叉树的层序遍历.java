package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {

        LinkedList<List<Integer>> res = new LinkedList<>();

        if (root==null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                List<Node> children = node.children;
                if (children != null) {
                    for (Node child : children) {
                        queue.offer(child);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
