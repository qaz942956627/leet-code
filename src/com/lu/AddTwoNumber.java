package com.lu;

/***
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 * @author 小卢
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNde = new ListNode(0);
        ListNode n1 = l1, n2 = l2, sum = sumNde;

        int carry = 0;
        while (n1 != null || n2 != null) {
            int a = n1 != null ? n1.val : 0;
            int b = n2 != null ? n2.val : 0;
            int intSum = a + b + carry;
            sum.next = new ListNode(intSum % 10);
            sum = sum.next;
            carry = intSum / 10;

            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        if (carry > 0) {
            sum.next = new ListNode(carry);
        }
        return sumNde.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


