package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class SolutionJ35 {
    public Node copyRandomList(Node head) {
        Node headNode = head;
        Map<Node, Node> mapping = new HashMap<>();

        while (head != null) {

            mapping.put(head, new Node(head.val));
            head = head.next;
        }

        head = headNode;

        while (head != null) {

            Node node = mapping.get(head);
            if (head.next!=null) {
                node.next = mapping.get(head.next);
            }

            if (head.random!=null) {
                node.random = mapping.get(head.random);
            }
            head = head.next;
        }

        return mapping.get(headNode);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
