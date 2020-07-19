package com.lu.list;

public class _35_搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        //默认插入在最右边
        int index = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;

            int num = nums[mid];
            if (target <= num) {
                //如果目标值小于中间元素 还需要往左找  当left=right的时候还能进入这个分支则当前地址就是要插入的地址
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
