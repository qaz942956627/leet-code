package linkedlist;

/**
 * @author 小卢
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void print() {
        System.out.print(val + " -> ");
        while (next!=null) {
            System.out.print(next.val+" -> ");
            next = next.next;
        }
    }
}
