package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution12 {
    public String intToRoman(int num) {

        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;
        int length = nums.length;
        while (index < length) {
            int num1 = nums[index];
            int res = num - num1;
            if (res >= 0) {
                stringBuilder.append(romans[index]);
                num = res;
            } else {
                index++;
            }

        }

        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
