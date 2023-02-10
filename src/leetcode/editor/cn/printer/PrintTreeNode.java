package leetcode.editor.cn.printer;

import leetcode.editor.cn.TreeNode;

public class PrintTreeNode implements BinaryTreeInfo{

    private final TreeNode root;

    public PrintTreeNode(TreeNode root) {
        this.root = root;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((TreeNode)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((TreeNode)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((TreeNode)node).val;
    }
}
