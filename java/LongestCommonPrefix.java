public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"abcd", "abc", "abcde"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        int left = 0, right = minLen;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (helper(strs, strs[0].substring(0, mid + 1))) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return strs[0].substring(0, left);
    }

    public boolean helper(String[] strs, String prefix) {
        for (String s : strs) {
            if (!s.substring(0, prefix.length()).equals(prefix)) {
                return false;
            }
        }

        return true;
    }
}
