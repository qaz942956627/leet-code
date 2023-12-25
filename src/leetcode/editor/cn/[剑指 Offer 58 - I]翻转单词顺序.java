package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution058 {
    public String reverseWords(String s) {

        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            String str = split[i];
            if (!str.isEmpty()) {
                sb.append(str).append(" ");
            }
        }

        return sb.toString().trim();
    }


}
//leetcode submit region end(Prohibit modification and deletion)
