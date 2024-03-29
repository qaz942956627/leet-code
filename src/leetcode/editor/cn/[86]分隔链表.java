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
class Solution86 {
    public ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;

        while (head != null) {

            if (head.val < x) {
                cur1.next = new ListNode(head.val);
                cur1 = cur1.next;

            } else {
                cur2.next = new ListNode(head.val);
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = dummy2.next;
        return dummy1.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
