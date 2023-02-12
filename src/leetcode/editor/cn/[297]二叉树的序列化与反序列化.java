package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    final String NULL = "#";
    final String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder buffer = new StringBuilder();
        serialize(root, buffer);
        return buffer.toString();

    }

    void serialize(TreeNode root, StringBuilder buffer) {

        if (root == null) {
            buffer.append(NULL).append(SEP);
            return;
        }
        buffer.append(root.val).append(SEP);
        serialize(root.left, buffer);
        serialize(root.right, buffer);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(SEP);

        LinkedList<String> nodeVal = new LinkedList<>(Arrays.asList(values));
        return deserialize(nodeVal);

    }

    TreeNode deserialize(LinkedList<String> nodeVal) {

        if (nodeVal.isEmpty()) {
            return null;
        }
        String val = nodeVal.removeFirst();
        if (NULL.equals(val)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(val));

        treeNode.left = deserialize(nodeVal);
        // 在left 递归调用遇到NULL 的时候 开始递归遍历右节点
        treeNode.right = deserialize(nodeVal);
        // 在right 递归调用遇到NULL 的时候 当前子树构建完成返回
        return treeNode;

    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
