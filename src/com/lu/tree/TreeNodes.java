package com.lu.tree;

import java.util.Arrays;
import java.util.List;

public class TreeNodes {
    String val;
    TreeNodes parent;
    List<TreeNodes> children;

    TreeNodes(String x) {
        val = x;
    }

    public static void main(String[] args) {
        String[] array = {"a","ab", "ac", "b", "bc","bcd"};
        Arrays.sort(array);

        TreeNodes root = new TreeNodes(null);

    }

}