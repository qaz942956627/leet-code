package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ16 {

    // 傻逼数学题
    public double myPow(double x, int n) {
        if (n==0) {
            return 1;
        }
        double res = x;
        if (n>0) {
            while (n > 1) {
                res *= x;
                n--;
            }
            return res;
        }

        while (n < -1) {
            res *= x;
            n++;
        }
        return 1 / res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
