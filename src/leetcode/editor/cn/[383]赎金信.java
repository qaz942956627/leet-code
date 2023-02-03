package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] cnt = new int[26];
        char[] magazineChars = magazine.toCharArray();
        for (char c : magazineChars) {
            cnt[c-'a']++;
        }

        char[] ransomNoteChars = ransomNote.toCharArray();
        for (char c : ransomNoteChars) {
            cnt[c-'a']--;
            if (cnt[c-'a']<0) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
