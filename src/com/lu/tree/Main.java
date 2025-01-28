package com.lu.tree;

import java.util.*;

class Node {
    String val;
    List<Node> children = new ArrayList<>();

    Node(String val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] array = {"a", "ab", "ac", "b", "bc", "bcd", "abcdefgh"};
        Arrays.sort(array);
        Map<String, Node> map = new HashMap<>();

        int length = array.length;


        // 创建虚拟的根节点
        Node root = new Node("");
        map.put("", root);
        Node currNode = new Node(array[0]);
        root.children.add(currNode);

        for (int i = 1; i < length; i++) {

        }

        for (String s : array) {
            map.put(s, new Node(s));
        }


        for (String s : array) {
            for (int i = 1; i <= s.length(); i++) {
                String parent = s.substring(0, i);
                if (map.containsKey(parent)) {
                    map.get(parent).children.add(map.get(s));
                    break;
                }
            }
        }

        printTree(root, "");
    }

    private static void printTree(Node node, String indent) {
        if (node == null) {
            return;
        }
        if (!node.val.isEmpty()) {
            System.out.println(indent + node.val);
        }
        for (Node child : node.children) {
            printTree(child, indent + "  ");
        }
    }
}
