package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ20 {
    public boolean isNumber(String s) {
        String str = s.trim();
        boolean numFlag = false;
        boolean eFlag = false;
        boolean dianFlg = false;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) {
                numFlag = true;
            } else if(ch == '.' && !dianFlg && !eFlag && ( (i+1 <str.length() &&  Character.isDigit(str.charAt(i+1)) || (i!=0 && numFlag)))) {
                dianFlg = true;
            } else if((ch == 'e' || ch == 'E') && !eFlag && numFlag ) {
                eFlag = true;
                numFlag = false;
            } else if((ch == '-' || ch == '+') && (i==0 || str.charAt(i-1) == 'e' ||str.charAt(i-1) == 'E' )) {

            }
            else {
                return false;
            }

        }
        return numFlag;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
