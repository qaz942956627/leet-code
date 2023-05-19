package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ13 {

    int res = 0;

    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];


        dfs(m, n, k, 0, 0, visited);
        return res;

    }

    private void dfs(int m, int n, int k, int mIndex, int nIndex, boolean[][] visited) {

        // 处理索引越界
        if (mIndex >= m || nIndex >= n || mIndex < 0 || nIndex < 0) {
            return;
        }

        // 如果已经访问过了
        if (visited[mIndex][nIndex]) {
            return;
        }


        int sum = 0;
        if (mIndex > 9) {
            sum += mIndex % 10;
            sum += mIndex / 10;
        } else {
            sum += mIndex;
        }

        if (nIndex > 9) {
            sum += nIndex % 10;
            sum += nIndex / 10;
        } else {
            sum += nIndex;
        }

        // 不允许进入坐标和大于K的位置
        if (sum > k) {
            return;
        }

        visited[mIndex][nIndex] = true;
        res++;
        dfs(m, n, k, mIndex - 1, nIndex, visited);
        dfs(m, n, k, mIndex + 1, nIndex, visited);
        dfs(m, n, k, mIndex, nIndex - 1, visited);
        dfs(m, n, k, mIndex, nIndex + 1, visited);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
