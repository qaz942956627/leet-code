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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    int depth = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        // 没有任何子节点 高度就是本身的节点
        if (root.children == null) {
            return 1;
        }
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }

        return max + 1;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node3 = new Node(3);
        node3.children = Arrays.asList(new Node(5), new Node(6));
        node.children = Arrays.asList(node3, new Node(2), new Node(4));

        Solution solution = new Solution();
        System.out.println(solution.maxDepth(node));

    }
    public int maxDepth1(Node root) {
        if (root == null) {
            return depth;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.children!=null) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            depth++;
        }

        return depth;
    }

    void traverse(Node root) {
        if (root == null) {
            return;
        }



        List<Node> children = root.children;
        for (Node child : children) {
            traverse(child);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
