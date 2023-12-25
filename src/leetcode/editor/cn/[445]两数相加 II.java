package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.Stack;

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
class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(-1);

        ListNode p = dummy;

        int carry = 0;
        while (carry > 0 || !stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = carry;
            if (!stack1.isEmpty()) {
                Integer pop1 = stack1.pop();
                sum += pop1;
            }

            if (!stack2.isEmpty()) {
                Integer pop2 = stack2.pop();
                sum += pop2;
            }

            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            // 把已经逆序好的元素放在新节点的next
            newNode.next = p.next;
            // 让虚拟节点的next = 新节点
            p.next = newNode;

        }
        return dummy.next;

    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.addTwoNumbers(ListNode.build(Arrays.asList(7, 2, 4, 3)),ListNode.build(Arrays.asList(5,6,4)));
//    }

    void traverse(ListNode root, Stack<Integer> stack) {
        if (root ==null) {
            return;
        }

        stack.push(root.val);
        traverse(root.next, stack);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
