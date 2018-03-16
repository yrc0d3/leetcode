public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
//        String s3 = "aadbbbaccc";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }

        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) != s3.charAt(i - 1)) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j - 1) != s3.charAt(j - 1)) {
                break;
            }
            dp[0][j] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) ||
                        (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
//                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
//                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
//                } else if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
//                    dp[i][j] = dp[i - 1][j];
//                } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
//                    dp[i][j] = dp[i][j - 1];
//                } else {
//                    dp[i][j] = false;
//                }
            }
        }

        return dp[m][n];
    }

    public boolean helper(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) {
            return true;
        }
        if (i == s1.length()) {
            if (s2.charAt(j) == s3.charAt(k)) {
                return helper(s1, s2, s3, i, j + 1, k + 1);
            } else {
                return false;
            }
        }
        if (j == s2.length()) {
            if (s1.charAt(i) == s3.charAt(k)) {
                return helper(s1, s2, s3, i + 1, j, k + 1);
            } else {
                return false;
            }
        }

        if (s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
            return helper(s1, s2, s3, i + 1, j, k + 1) || helper(s1, s2, s3, i, j + 1, k + 1);
        } else if (s1.charAt(i) == s3.charAt(k)) {
            return helper(s1, s2, s3, i + 1, j, k + 1);
        } else if (s2.charAt(j) == s3.charAt(k)) {
            return helper(s1, s2, s3, i, j + 1, k + 1);
        } else {
            return false;
        }
    }
}
