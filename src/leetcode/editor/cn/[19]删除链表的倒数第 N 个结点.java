package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 找到要删除节点的前一个节点,传虚拟节点不传head可以防止空指针
        // 这个方法是查找倒数第n个元素的 前边增加一个节点不影响结果
        ListNode prev = findPrev(dummy, n + 1);

        // 删除目标节点
        prev.next = prev.next.next;
        return dummy.next;

    }

    /**
     * 找到倒数第n+1个节点,也就是要删除的节点的前一个节点
     *
     * @param head 头
     * @param n    n
     * @return {@link ListNode}
     */
    public ListNode findPrev(ListNode head, int n) {

        ListNode first = head, second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
