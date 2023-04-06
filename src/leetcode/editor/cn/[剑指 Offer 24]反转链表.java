package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SolutionJ24 {
    public ListNode reverseList(ListNode head) {

        ListNode dummy = new ListNode();

        traverse(head, dummy);
        return dummy.next;

    }

    private ListNode traverse(ListNode head,ListNode res) {
        if (head==null) {
            return res;
        }
        res = traverse(head.next, res);
        res.next = new ListNode(head.val);
        return res.next;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.reverseList(ListNode.build(Arrays.asList(1, 2, 3, 4, 5)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
