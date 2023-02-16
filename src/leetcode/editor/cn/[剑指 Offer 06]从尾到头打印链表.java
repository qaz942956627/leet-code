package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SolutionJ06 {

    int[] res;

    int len = 0;
    int index = 0;
    public int[] reversePrint(ListNode head) {

        traverse(head);
        return res;

    }

    void traverse(ListNode head) {

        if (head==null) {
            res = new int[len];
            return;
        }
        len++;
        traverse(head.next);
        // 后序位置进行赋值
        res[index] = head.val;
        index++;
    }

    public int[] reversePrint1(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            ListNode pop = stack.pop();
            res[i] = pop.val;
        }
        return res;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
