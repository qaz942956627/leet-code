package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ53 {
    int iLength;
    int jLength;
    public int[][] updateMatrix(int[][] mat) {

        iLength = mat.length;
        jLength = mat[0].length;

        int[][] res = new int[iLength][jLength];

        // 初始化数组 如果元素值不等于-1 则说明访问过了
//        for (int[] arr : res) {
//            Arrays.fill(arr, -1);
//        }

        // 四叉树的层序遍历
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                if (mat[i][j] == 0) {
                    // 找到所有元素为0的位置
                    queue.offer(new int[]{i, j});
                    res[i][j] = 0;
                } else {
                    // 元素为1不能确定值是什么 先初始化个-1 表示没访问过
                    res[i][j] = -1;
                }
            }
        }
        // 向四周扩散
        int[][] nodes = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int iCurr = poll[0];
            int jCurr = poll[1];


            for (int[] node : nodes) {

                int iIndex = iCurr + node[0];
                int jIndex = jCurr + node[1];

                // 判断索引不能越界 并且dp[i][j]==-1 计算一下走到这的最小步骤
                if (iIndex >= 0 && jIndex >= 0 &&
                        iIndex < iLength && jIndex < jLength &&
                        res[iIndex][jIndex] == -1) {
                    queue.offer(new int[]{iIndex, jIndex});
                    // 从 mat[iCurr][jCurr]] 走到 mat[iIndex][jIndex] 需要一步
                    // 因为是从每个起点进行的层序遍历 所以走到每个res[iIndex][jIndex]==-1的时候
                    // 都是从最近的0第一次走到 所以直接上一步+1就行了 不需要考虑其他root节点走到这个的场景那必然步数>=这次结算结果
                    res[iIndex][jIndex] = res[iCurr][jCurr] + 1;
                }

            }

        }
        return res;

    }


    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
