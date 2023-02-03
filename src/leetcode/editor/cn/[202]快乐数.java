package leetcode.editor.cn;

class Solution202 {
    public boolean isHappy(int n) {



        return false;
    }

    int sum(int n) {
        int tmp;
        int sum = 0;
        while (n>0) {
            tmp = n % 10;
            n = n / 10;
            sum += tmp * tmp;
        }
        return sum;
    }
}
