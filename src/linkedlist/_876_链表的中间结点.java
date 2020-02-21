package linkedlist;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @author 小卢
 */
public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode midd = head;
        int size = 0;
        while (head.next != null) {
            size++;
            head = head.next;
        }
        if (size % 2 == 0) {
            for (int i = 0; i < (size / 2) + 1; i++) {
                midd = midd.next;
            }
        }else {
            for (int i = 0; i < (size / 2); i++) {
                midd = midd.next;
            }
        }
        return midd;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    public ListNode middleNode3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
