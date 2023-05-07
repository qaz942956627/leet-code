package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution455 {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int index = 0;
        //这个方法就是优先考虑我们的小胃口 如果我们的当前的饼干大小刚好可以满足我们的最小的孩子我们就可以继续看下一个孩子
        for (int j : s) {
            if (index < g.length && g[index] <= j) {
                index++;
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
