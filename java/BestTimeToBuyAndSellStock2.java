public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ret += prices[i] - prices[i - 1];
            }
        }

        return ret;
    }
}
