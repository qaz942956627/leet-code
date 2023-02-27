package leetcode.editor.cn;

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.PriorityQueue;

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
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        int k = lists.length;
        if (k == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a.val));


        for (ListNode listNode : lists) {
            ListNode list = listNode;
            while (list != null) {
                priorityQueue.add(new ListNode(list.val));
                list = list.next;
            }
        }
        while (!priorityQueue.isEmpty()) {
            cur.next = priorityQueue.poll();
            cur = cur.next;
        }

        return dummy.next;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
