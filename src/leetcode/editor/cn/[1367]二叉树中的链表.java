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
class Solution1367 {
    boolean res = false;

    /**
     * 递归解法
     *
     * @param head 头
     * @param root 根
     * @return boolean
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        traverse(head, root);
        return res;
    }


    void traverse(ListNode head, TreeNode root) {
        if (res || root == null) {
            return;
        }

        // 只有完全匹配上才return 没匹配上继续判断后边的 不是return false
        if (check(head, root)) {
            res = true;
            return;
        }

        traverse(head,root.left);
        traverse(head, root.right);
    }


    /**
     * 分解子问题解法
     *
     * @param head 头
     * @param root 根
     * @return boolean
     */
    public boolean isSubPath1(ListNode head, TreeNode root) {
        if (head==null) {
            return true;
        }
        if (root==null) {
            return false;
        }

        // 一旦头结点相等就要连续判断链表和
        if (head.val == root.val) {
            // 只有完全匹配上才return 没匹配上继续判断后边的 不是return false
            if (check(head, root)) {
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);

    }

    boolean check(ListNode head, TreeNode root) {
        if (head==null) {
            return true;
        }
        if (root==null) {
            return false;
        }

        // 当前节点相等判断后边的
        if (head.val == root.val) {
            return check(head.next, root.left) || check(head.next, root.right);
        }
        // 有任何一个节点没对上则不是连续匹配
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
