package com.lu.list;

public class _26_删除排序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            //每次不相等需要让慢指针的下一个元素的值等于快指针的值
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public int removeDuplicates1(int[] nums) {
        int kuaDu = 0;
        int i = 0;
        while (i + kuaDu < nums.length-1) {
            if (nums[i] == nums[i + 1 + kuaDu]) {
                nums[i + 1] = nums[i + 1 + kuaDu];
                kuaDu++;
            } else {
                nums[i + 1] = nums[i + 1 + kuaDu];
                i++;
            }
        }
        return nums.length-kuaDu;
    }
}
