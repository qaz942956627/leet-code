package leetcode.editor.cn;

import leetcode.editor.cn.printer.BinaryTrees;

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



import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {

        List<Integer> list = new ArrayList<>();


        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return sortedListToBST(list, 0, list.size() - 1);

    }


    TreeNode sortedListToBST(List<Integer> list, int left, int right) {
        if (left>right) {
            return null;
        }

        //int mid = left + (right - left) >> 1;
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = sortedListToBST(list, left, mid - 1);
        root.right = sortedListToBST(list, mid + 1, right);
        return root;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

//        Solution solution = new Solution();
//        TreeNode treeNode = solution.sortedListToBST(head);
        //BinaryTrees.println(treeNode);

    }





}
//leetcode submit region end(Prohibit modification and deletion)
