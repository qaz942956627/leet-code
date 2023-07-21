package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution116 {
    public Node connect(Node root) {
        if (root==null) {
            return null;
        }

        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node left, Node right) {
        if (left==null || right==null) {
            return;
        }
        // 前序位置将左右元素链接上
        left.next = right;
        traverse(left.left,left.right);
        traverse(right.left,right.right);
        traverse(left.right,right.left);


    }



}

//leetcode submit region end(Prohibit modification and deletion)
