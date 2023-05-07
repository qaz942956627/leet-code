package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution206 {


    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;


    }


    ListNode dummy;
    public ListNode reverseList1(ListNode head) {

        dummy = new ListNode(-1);
        ListNode res = dummy;


        traverse(head);
        return res.next;


    }

    void traverse(ListNode head) {
        if (head==null) {
            return;
        }

        traverse(head.next);
        dummy.next = new ListNode(head.val);
        dummy = dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
