import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }

    /*
    using a stack
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        if (stack.isEmpty()) {
            return s.length();
        }

        int longest = 0;
        int hi = s.length(), lo = 0;
        while (!stack.isEmpty()) {
            lo = stack.pop();
            longest = Math.max(longest, hi - lo - 1);
            hi = lo;
        }
        longest = Math.max(longest, hi);
        return longest;
    }

    /*
    dynamic programming
    dp[i] means the longest length of valid parentheses which is end at i.
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int n = s.length(), max = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}
