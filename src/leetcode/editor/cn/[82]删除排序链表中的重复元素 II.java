package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

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
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, q = head;
        while (q != null) {

            if (q.next != null && q.val == q.next.val) {
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                q = q.next;
                // 此时 q 跳过了这一段重复元素
                if (q == null) {
                    p.next = null;
                }
                // 不过下一段元素也可能重复，等下一轮 while 循环判断
            } else {
                p.next = q;
                q = q.next;
                p = p.next;
            }

        }
        return dummy.next;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.deleteDuplicates(ListNode.build(Arrays.asList(1, 2,2)));
//    }
}

//leetcode submit region end(Prohibit modification and deletion)
