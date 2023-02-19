package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 遍历A 如果A中某个节点的值和b的根节点值相等 开始判断a当前的子树和B是不是完全相同
        if (A.val == B.val && checkMatch(A, B)) {
            return true;
        }

        // 遍历A的所有子节点 有任何一个匹配上就算成功
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    boolean checkMatch(TreeNode root, TreeNode b) {

        // 当B==null的时候证明B的左边或者右边已经匹配完了
        if (b == null) {
            return true;
        }

        // B!=null 但是root==null 证明不可能匹配上了
        if (root == null) {
            return false;
        }

        // 两个相同位置的节点值不相等证明不匹配
        if (root.val != b.val) {
            return false;
        }
        // 两个位置都不为null并且值相等,继续匹配左右子树
        return checkMatch(root.left, b.left)&&checkMatch(root.right, b.right);

    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.buildTree(new Integer[]{1, 0, 1, -4, -3});
//        TreeNode b = TreeNode.buildTree(new Integer[]{1, -4});
//        Solution solution = new Solution();
//        solution.isSubStructure(root, b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
