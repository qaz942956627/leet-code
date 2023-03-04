package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SolutionJ18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode root = head;
        ListNode pre = head;

        if (root.val==val) {
            return root.next;
        }
        head = head.next;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                return root;
            }
            head = head.next;
            pre = pre.next;
        }
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
