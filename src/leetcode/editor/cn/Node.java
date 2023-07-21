package leetcode.editor.cn;

import java.util.List;

class Node {
    public int val;
    Node next;
    Node left;
    Node right;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public List<Node> children;

    public Node() {
    }

//    public Node(int val) {
//        this.val = val;
//    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
};