package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution6 {
    public String convert(String s, int numRows) {
        int length = s.length();
        int count = length / numRows;
        if (length %numRows==0) {
            count++;
        }
        char[][] arr = new char[count][numRows];

        return null;
    }

    public static void main(String[] args) {
        char[][] arr = new char[2][3];
        arr[0] = new char[]{'1', '2', '3'};
        arr[1] = new char[]{'4', '5', '6'};
        for (char[] ints : arr) {
            for (char anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
