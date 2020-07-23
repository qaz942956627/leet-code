package com.lu.list;

public class _88_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = n + m - 1; i >= 0; i--) {
            if (m==0) {
                for (int j = n-1; j >= 0; j--) {
                    nums1[j] = nums2[j];
                }
                return;
            }
            if (n == 0) {
                return;
            }
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[--m];
            } else {
                nums1[i] = nums2[--n];
            }
        }
    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 两个获取指针nums1和nums2
            int p1 = m - 1;
            int p2 = n - 1;
            // 设置指针为nums1
            int p = m + n - 1;

            // while there are still elements to compare
            while ((p1 >= 0) && (p2 >= 0))
                // compare two elements from nums1 and nums2
                // and add the largest one in nums1
                nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

            // add missing elements from nums2
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }

}
