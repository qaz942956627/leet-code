package leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class SolutionJ36 {



    /**
     * 定义：输入一棵 BST，返回该 BST 改造成的环形链表的头结点
     *
     * @param root 根
     * @return {@link Node}
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);

        Node leftTail, rightTail;


        // 根节点接到左右两个环形链表中间
        if (leftHead != null) {
            leftTail = leftHead.left;
            root.left = leftTail;
            leftTail.right = root;
        } else {
            // 左子树为空所以最左边的就是root
            leftTail = leftHead = root;
        }
        if (rightHead != null) {
            rightTail = rightHead.left;
            root.right = rightHead;
            rightHead.left = root;
        } else {
            rightTail = rightHead = root;
        }

        // 两个环形链表头尾相接形成大的环形链表
        leftHead.left = rightTail;
        rightTail.right = leftHead;

        return leftHead;

    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        Node root = new Node(4);
//        root.left = new Node(2);
//        root.right = new Node(5);
//        root.left.left = new Node(1);
//        root.left.right = new Node(3);
//        solution.treeToDoublyList(root);
//    }




    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
//leetcode submit region end(Prohibit modification and deletion)
