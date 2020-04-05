package linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author 小卢
 */
public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}
