package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 函数的定义 就是返回rowIndex所在行的结果
     * 每一行都是上一行的两个数相加
     * 前边加个1后边再加个1
     *
     * @param rowIndex 行索引
     * @return {@link List}<{@link Integer}>
     */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>(rowIndex);

        res.add(1);
        if (rowIndex == 0) {
            return res;
        }

        // 拿到上一行的结果
        List<Integer> preRow = getRow(rowIndex - 1);
        // 两数相加 所以遍历size-1
        for (int i = 0; i < preRow.size() - 1; i++) {
            // 当前行的没一个树都是上一行的两个数相加
            res.add(preRow.get(i) + preRow.get(i + 1));
        }
        res.add(1);

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
