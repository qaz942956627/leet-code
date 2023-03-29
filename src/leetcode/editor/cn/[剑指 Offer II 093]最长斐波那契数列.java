package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ093 {



    public int lenLongestFibSubseq(int[] arr) {

        int length = arr.length;

        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            valueIndexMap.put(arr[i], i);
        }

        // dp数组的含义 dp[i][j] 表示以i,j为终点的斐波那契数列的值 0<=i<j<length
        int[][] dp = new int[length][length];

        // 0<=i<j<length 所有合法的dp[i][j]的斐波那契数量至少两个元素
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = 2;
            }
        }
        int res = 0;

        // prevIndex < midIndex < rightIndex

        for (int midIndex = 0; midIndex < length; midIndex++) {
            for (int rightIndex = midIndex + 1; rightIndex < length; rightIndex++) {
                int prevValue = arr[rightIndex] - arr[midIndex];
                Integer prevIndex = valueIndexMap.get(prevValue);
                // 如果valueIndexMap没有对应的元素直接跳出循环
                if (prevIndex == null) {
                    // res = Math.max(res, dp[midIndex][rightIndex]);
                    continue;
                }
                // 如果 左边元素的索引>=中间元素索引 一定是不合法的直接跳出循环
                if (prevIndex >= midIndex) {
                    // res = Math.max(res, dp[midIndex][rightIndex]);
                    continue;
                }
                // dp[midIndex][rightIndex] = Math.max(dp[midIndex][rightIndex], dp[prevIndex][midIndex] + 1);
                // 因为dp[midIndex][rightIndex] 一定被初始化成2或者算好了 所以不需要max 直接+1就行
                dp[midIndex][rightIndex] = dp[prevIndex][midIndex] + 1;
                res = Math.max(res, dp[midIndex][rightIndex]);
            }
        }

        return res > 2? res : 0;

    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }



    public int lenLongestFibSubseq1(int[] arr) {

        int length = arr.length;

        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            valueIndexMap.put(arr[i], i);
        }

        int res = 0;
        // dp数组的含义 dp[i][j] 表示以i,j为终点的斐波那契数列的值 0<=i<j<length
        // int[][] dp = new int[length][length];

        for (int j = length-1; j > 0; j--) {
            for (int i = j-1; i >= 0; i--) {
                // LinkedList<Integer> fibSubseq = getFibSubseq(arr, i, j, valueIndexMap);
                // res = Math.max(fibSubseq.size(), res);
                res = Math.max(getFibSubseq(arr, i, j, valueIndexMap), res);
            }
        }

        return res > 2 ? res : 0;
    }

    private int getFibSubseq(int[] arr, int i, int j, Map<Integer, Integer> valueIndexMap) {
        int last = arr[j];
        int prevValue = arr[i];
        // LinkedList<Integer> res = new LinkedList<>();
        // res.addFirst(last);
        int rest = 1;

        Integer prevIndex;
        while (true) {
            rest++;
            // res.addFirst(prevValue);
            prevIndex = valueIndexMap.get(last - prevValue);
            if (prevIndex == null || last - prevValue >= prevValue) {
                break;
            }
            last = prevValue;
            prevValue = arr[prevIndex];
        }
        return rest;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
