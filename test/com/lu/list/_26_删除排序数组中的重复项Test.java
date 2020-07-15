package com.lu.list;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class _26_删除排序数组中的重复项Test {

    @Test
    void removeDuplicates() {
        int[] ints = {1,1};
        _26_删除排序数组中的重复项 v = new _26_删除排序数组中的重复项();
        v.removeDuplicates(ints);
    }

    @Test
    void dequeTest() {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offer(4);
        System.out.println(deque.peek());
        System.out.println(deque.pop());
        System.out.println(deque.peek());
    }
}