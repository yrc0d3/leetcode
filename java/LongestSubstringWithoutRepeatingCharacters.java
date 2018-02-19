public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[] pos = new int[256];
        int begin = 0, max = 1;
        for (int i = 0; i < chars.length; i++) {
            begin = Math.max(begin, pos[chars[i]]);
            pos[chars[i]] = i;
            max = Math.max(max, i - begin);
        }

        return max;
    }
}
