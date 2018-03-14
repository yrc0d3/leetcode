public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("1212"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else if (c >= '7' && c <= '9') {
                dp[i + 1] = s.charAt(i - 1) == '1' ? dp[i] + dp[i - 1] : dp[i];
            } else {
                dp[i + 1] = (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') ? dp[i] + dp[i - 1] : dp[i];
            }
        }

        return dp[s.length()];
    }
}
