package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ11 {
    public int minArray(int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {

            while (numbers[left] == numbers[right]) {
                right--;
            }
            int mid = left + (right - left) /2;

            if (numbers[mid] < numbers[left]) {
                // mid落在断崖的右边

                right = mid -1;
            } else if (numbers[mid] > numbers[left]) {
                // mid落在断崖的左边
                left = mid + 1;
            } else {
                return numbers[mid];
            }
        }

        return numbers[left];

    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.minArray(new int[]{1, 3, 5}));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
