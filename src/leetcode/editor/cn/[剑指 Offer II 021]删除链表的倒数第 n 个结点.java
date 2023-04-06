package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class SolutionJ021 {

    int size = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;

        traverse(dummy, n);
        return dummy.next;
    }

    private void traverse(ListNode head, int n) {
        if (head==null) {
            return;
        }

        traverse(head.next, n);

        size++;
        // 要删除倒数第一个得找到倒数第二个的节点才能删除倒数第一个
        if (size == n + 1) {
            head.next = head.next.next;
        }

    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.removeNthFromEnd(ListNode.build(Arrays.asList(1, 2, 3, 4, 5)), 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
