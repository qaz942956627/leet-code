package com.lu.list;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _27_移除元素 {

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            //如果快指针元素不等val 则让慢指针元素等于快指针元素 并让慢指针加一
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public int removeElement1(int[] nums, int val) {

        int start = 0;
        int end = nums.length;
        while (end > start) {
            if (val == nums[start]) {

                // reduce array size by one
                nums[start] = nums[end - 1];
                end--;
            } else {
                start++;
            }
        }
        return end;
    }
}
