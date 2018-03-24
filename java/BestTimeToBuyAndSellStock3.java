public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStock3().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        return maxProfit(prices, 2);
    }

    public int maxProfit(int[] prices, int k) {
        if (k <= 0 || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        if (k >= n / 2) {
            int ret = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    ret += prices[i] - prices[i - 1];
                }
            }
            return ret;
        }

        // dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][x] - prices[x])) 0<=x<=j-1
        // could use dp[n] to decrease space complexity
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int tmp = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmp);
                tmp = Math.max(tmp, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }
}
