package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution258 {
    public int addDigits1(int num) {
        String value = String.valueOf(num);
        char[] chars = value.toCharArray();
        int sum = 0;

        for (char c : chars) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        if (sum < 10) {
            return sum;
        }

        return addDigits(sum);
    }

    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
