package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果链表长度为奇数则fast是最后一个节点

        // 链表长度为奇数时slow需要再走一步 中间单独的节点就不需要比较了

        if (fast != null) {
            slow = slow.next;
        }

        ListNode right = reverse(slow);
        ListNode left = head;

        while (right != null) {
            if (left.val!=right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;


    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            // 备份上一个节点
            ListNode next = cur.next;
            // 当前节点的下一个节点换成上一个节点
            cur.next = pre;
            // 备份上一个节点变成当前节点
            pre = cur;
            // 当前节点指向下一个节点
            cur = next;
        }
        return pre;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
