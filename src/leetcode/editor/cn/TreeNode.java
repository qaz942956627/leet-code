package leetcode.editor.cn;

import leetcode.editor.cn.printer.BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lu
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }


    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    void createFullBT_DFS(TreeNode root, Integer[] numbers, int len, int i, TreeNode print) {
        if (i <= len) {
            root.val = numbers[i - 1];
            BinaryTrees.println(print);
            System.out.println("-------"+root.val+"------");
            if (2 * i <= len && numbers[2 * i - 1] != null) {
                root.left = new TreeNode();
                // createFullBT_DFS(root.left, numbers, len, 2 * i);
                createFullBT_DFS(root.left, numbers, len, 2 * i, print);
            }
            if ((2 * i + 1) <= len && numbers[2 * i] != null) {
                root.right = new TreeNode();
                // createFullBT_DFS(root.right, numbers, len, 2 * i + 1);
                createFullBT_DFS(root.right, numbers, len, 2 * i + 1, print);
            }
        }
    }

    static TreeNode buildTree(Integer[] numbers) {

        TreeNode treeNode = new TreeNode();
        // treeNode.createFullBT_DFS(treeNode, numbers, numbers.length, 1);
        treeNode.createFullBT_DFS(treeNode, numbers, numbers.length, 1, treeNode);
        return treeNode;
    }

    public static void main(String[] args) {
        Integer[] numbers = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);


        TreeNode treeNode = TreeNode.buildTree(numbers);
        BinaryTrees.println(root);
        BinaryTrees.println(treeNode);


    }

}