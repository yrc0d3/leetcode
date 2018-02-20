public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] cc = s.toCharArray();
        String ret = s.substring(0, 1);
        for (int i = 1; i < cc.length; i++) {
            int oddLen = helper(cc, i, i);
            int evenLen = helper(cc, i - 1, i);
            int maxLen = Math.max(oddLen, evenLen);
            if (maxLen > ret.length()) {
                ret = new String(cc, i - maxLen / 2, maxLen);
            }
        }
        return ret;
    }

    public int helper(char[] cc, int left, int right) {
        while (left >= 0 && right < cc.length && cc[left] == cc[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
