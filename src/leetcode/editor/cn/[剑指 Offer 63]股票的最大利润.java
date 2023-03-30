package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ63 {
    public int maxProfit(int[] prices) {

        int res = 0;
        int length = prices.length;

        for (int i = 0; i < length - 1; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < length; j++) {
                int sell = prices[j];
                res = Math.max(sell - buy, res);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }


}
//leetcode submit region end(Prohibit modification and deletion)
