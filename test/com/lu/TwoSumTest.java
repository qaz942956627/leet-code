package com.lu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSum() {
        int[] nums = {1, 2, 4, 6, 7, 12, 345, 6, 77, 23};
        int[] twoSum = TwoSum.twoSum(nums, 9);
        int[] twoSum1 = TwoSum.twoSum1(nums, 9);
        int[] twoSum2 = TwoSum.twoSum2(nums, 346);
        assertArrayEquals(new int[]{1,4},twoSum);
        assertArrayEquals(new int[]{1,4},twoSum1);
        assertArrayEquals(new int[]{0,6},twoSum2);
    }
}