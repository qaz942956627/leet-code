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

class Solution589 {

    List<Integer> res;
    public List<Integer> preorder(Node root) {

        res = new LinkedList<>();
        traverse(root);
        return res;
    }

    void traverse(Node root) {

        if (root == null) {
            return;
        }

        List<Node> children = root.children;
        res.add(root.val);
        for (Node node : children) {
            traverse(node);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
