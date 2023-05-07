package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
class Solution2 {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);

        ListNode p = dummy;


//            进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;


            if (l1 == null) {

                sum = l2.val;
                l2 = l2.next;

            } else if (l2 == null) {
                sum = l1.val;
                l1 = l1.next;

            } else {
                sum += l1.val;
                sum += l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            sum += carry;
            int i = sum % 10;
            carry = sum / 10;
            p.next = new ListNode(i);
            p = p.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;



    }


    public static void main(String[] args) {
//        ListNode l1 = ListNode.build(Arrays.asList(2,4,3));
//
//        ListNode l2 = ListNode.build(Arrays.asList(5,6,4));
//        Solution solution = new Solution();
//        solution.addTwoNumbers(l1, l2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
