package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution200 {

    int res = 0;

    public int numIslands(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // 发现一座岛屿 岛屿数量+1
                    res++;
                    bfs(grid, i, j);
                }
            }
        }
        return res;

    }

    void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        // 开始不一定是new int[]{0, 0} 而是第一个grid[i][j] == '1'的索引
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                check(grid, x, y, queue);

            }
        }
    }

    void check(char[][] grid, int x, int y,Queue<int[]> queue) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
            // 下标越界 直接返回
            return;
        }
        // 把这座岛屿全变成水
        grid[x][y] = '0';

        queue.add(new int[]{x - 1, y});
        queue.add(new int[]{x + 1, y});
        queue.add(new int[]{x, y - 1});
        queue.add(new int[]{x, y + 1});
    }


    public int numIslandsDfs(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // 发现一座岛屿 岛屿数量+1
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;

    }


    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            // 下标越界 直接返回
            return;
        }
        // 把这座岛屿全变成水
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }



}
//leetcode submit region end(Prohibit modification and deletion)
