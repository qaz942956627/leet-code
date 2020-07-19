package com.lu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    void divide2Test() {
        System.out.println(9/2);
    }

    @Test
    void tests22() {
        List<Integer> s = new ArrayList<>();
        s.add(0);
        s.add(01);
        s.add(02);
        s.add(03);
        s.add(04);
        List<Integer> collect = s.stream().filter(s1 -> s1.equals(9)).map(i -> {

            return i / 0;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void me() {
        String s = "sssssE001";
        System.out.println(s.substring(s.length()-4));
    }

    @Test
    void subStringTest() {
        StringBuilder sb = new StringBuilder();
        sb.append(123456);
        //获取倒数第二个元素的值
        String value = sb.substring(sb.length() - 2, sb.length() - 1);
        //获取连续出现的次数
        String lastCount = sb.substring(sb.length() - 1, sb.length());
    }
}