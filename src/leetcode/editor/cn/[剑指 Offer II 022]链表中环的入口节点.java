package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head, fast = head;


        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast==slow) {
                // 此时fast和slow相遇 fast走了 step*2步 slow走了 step步
                // 假设环起点到到相遇点距离为m 包含套圈距离
                // 此时快指针比慢指针快了step 环起点到head的距离为step-m
                //

                // 重新指向头结点
                slow = head;
                // 快慢指针同步前进，相交点就是环起点
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }

        }
        return null;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
