package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

//public class Solution extends GuessGame {
//    public int guessNumber(int n) {
//        int left = 1, right = n;
//        while (left < right) { // 循环直至区间左右端点相同
//            int mid = left + (right - left) / 2; // 防止计算时溢出
//            if (guess(mid) <= 0) {
//                right = mid; // 答案在区间 [left, mid] 中
//            } else {
//                left = mid + 1; // 答案在区间 [mid+1, right] 中
//            }
//        }
//        // 此时有 left == right，区间缩为一个点，即为答案
//        return left;
//    }
//
//}
//leetcode submit region end(Prohibit modification and deletion)
