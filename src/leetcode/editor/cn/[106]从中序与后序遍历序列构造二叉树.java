package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
class Solution106 {

    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // 设置中序遍历索引
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);

    }

    /**
     * 构建
     * 构建 postorder[preStart,preEnd] 的数
     *
     * @param inorder   中序遍历
     * @param inStart   中序遍历开始索引
     * @param inEnd     中序遍历结束索引
     * @param postorder 后序遍历
     * @param postStart 后续遍历开始索引
     * @param postEnd   后续遍历结束索引
     * @return {@link TreeNode}
     */
    TreeNode build(int[] inorder, int inStart, int inEnd,
                   int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];

        // 中序遍历中当前根节点的索引
        Integer inorderRootValIndex = indexMap.get(rootVal);

        // 左边元素的个数 算元素索引的时候需要-1
        int leftSize = inorderRootValIndex - inStart;

        // 新建根节点
        TreeNode root = new TreeNode(rootVal);

        // 构建左节点
        root.left = build(inorder, inStart, inorderRootValIndex - 1,
                postorder, postStart, postStart + leftSize - 1);

        // 构建右节点
        root.right = build(inorder, inorderRootValIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);

        return root;

    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
