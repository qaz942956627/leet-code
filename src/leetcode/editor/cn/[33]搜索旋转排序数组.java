package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution33 {


    public int search(int[] nums, int target) {
        // 左右都闭的搜索区间
        int left = 0, right = nums.length - 1;
        // 因为是闭区间，所以结束条件为 left > right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 首先检查 nums[mid]，是否找到 target
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                // 在断崖的左边搜索 nums[left->mid]是连续的
                if (nums[left] <= target && target < nums[mid]) {
                    // 如果就是在断崖的左边
                    right = mid - 1;
                } else {
                    // 如果不在断崖的左边
                    left = mid + 1;
                }
            } else {
                // 在断崖的右边 nums[mid->right]是连续的
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        // while 结束还没找到，说明 target 不存在
        return -1;
    }

    public static void main(String[] args) {
        // new Solution().search(new int[]{3,1}, 1);
    }

    private static int findMinIndex(int[] nums, int length) {
        int left = 0, right = length - 1;
        // 搜索区间为 [left, right]
        int target = nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                right = mid - 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                left = mid + 1;
            }else if (nums[mid] == target) {
                // 搜索区间变为 [left, mid-1]
                return mid;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大，返回 -1
         return left;
    }

    private static int binarySearch(int[] nums, int target, int left,int length) {
        int right = length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大，返回 -1
        if (left == length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
