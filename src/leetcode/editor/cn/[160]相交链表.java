package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }

        while (curB != null) {
            curB = curB.next;
            lenB++;
        }

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        }
        // 有任何一个走到最后还没有地址相等的就证明没有交点
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
