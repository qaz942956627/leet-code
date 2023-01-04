package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution401 {

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // System.out.println(solution.readBinaryWatch(2));
        System.out.println(Integer.toBinaryString(63));
        System.out.println(Integer.toBinaryString(1023));
    }

    int count = 0;
    boolean[] select = new boolean[10];
    List<String> results = new ArrayList<>();

    public List<String> readBinaryWatch1(int turnedOn) {
        // int[] times = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        // select = new boolean[10];

        select(0, turnedOn);

        return results;
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();

        // 1023 十个1     1111111111
        // 63   六个1     111111
        // i >> 6           只要高 4 位
        // i & 63           只要低 6 位
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6, m = i & 63; // 用位运算取出高 4 位和低 6 位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }

    public void select(int n, int turnedOn) {
        if (turnedOn == 0) {
            results.add(getResult(select));
            return;
        }
        for (int i = n; i < 10; i++) {
            // 先选择,在验证
            select[i] = true;
            if (isValid(i)) {
                // 如果先剪枝再选择可能会出现小时>11或者分钟>59的情况
                select(i + 1, turnedOn - 1);
            }
            select[i] = false;
        }
    }

    /**
     * 得到结果
     * ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
     *
     * @param select 选择
     * @return {@link String}
     */
    private String getResult(boolean[] select) {
        String result = "";
        // 处理小时
        int hour = 0;
        if (select[0]) {
            hour += 1;
        }
        if (select[1]) {
            hour += 2;
        }
        if (select[2]) {
            hour += 4;
        }
        if (select[3]) {
            hour += 8;
        }
        result += hour;
        result += ":";
        // 处理分钟
        int minute = 0;

        if (select[4]) {
            minute += 1;
        }
        if (select[5]) {
            minute += 2;
        }
        if (select[6]) {
            minute += 4;
        }
        if (select[7]) {
            minute += 8;
        }
        if (select[8]) {
            minute += 16;
        }
        if (select[9]) {
            minute += 32;
        }
        if (minute < 10) {
            result = result + "0" + minute;
        } else {
            result += minute;
        }
        return result;
    }

    /**
     * 将所有灯组成 nums = [1,2,4,8,1,2,4,8,16,32] =
     * [0,1,2,3,4,5,6,7,8 ,9 ]
     *
     * @param index  指数
     * @return boolean
     */
    boolean isValid(int index) {
        // 处理小时
        if (index < 4) {


        }
        int hour = 0;
        if (select[0]) {
            hour += 1;
        }
        if (select[1]) {
            hour += 2;
        }
        if (select[2]) {
            hour += 4;
        }
        if (select[3]) {
            hour += 8;
        }
        if (hour > 11) {
            return false;
        }
        // 处理分钟
        if (index < 4) {

        }
        int minute = 0;

        if (select[4]) {
            minute += 1;
        }
        if (select[5]) {
            minute += 2;
        }
        if (select[6]) {
            minute += 4;
        }
        if (select[7]) {
            minute += 8;
        }
        if (select[8]) {
            minute += 16;
        }
        if (select[9]) {
            minute += 32;
        }
        if (minute > 59) {
            return false;
        }

        return true;
    }

}
// leetcode submit region end(Prohibit modification and deletion)
